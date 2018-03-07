package spring_web_map.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring_web_map.dao.UserInfoDAO;
import spring_web_map.entity.User;
import spring_web_map.model.TuyencapInfo;
import spring_web_map.model.UserInfo;
import spring_web_map.validator.UserValidator;

@Controller
@Transactional
@EnableWebMvc
public class MainPageController {

	@Autowired
	UserInfoDAO userInfoDAO;

	@Autowired(required = true)
	private UserValidator userValidator;

	@RequestMapping("/main")
	public String hello(Model model) {

		model.addAttribute("greeting", "MY NO-IP SERVICE");

		return "mainPage";

	}

	// login code
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping("/thietbi_cauhinh")
	public String thietbi_cauhinh(Model model) {

		model.addAttribute("hoàn tất!", "HẠ TẦNG TRUYỀN DẪN");

		return "thietbi_cauhinh";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		return "userInfoPage";
	}

	@RequestMapping(value = "/userManager", method = RequestMethod.GET)
	public String userManager(Model model, @RequestParam("subPageParam") String subPageParam, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		// System.out.println("User Name: " + userName);
		// List<UserInfo> userData = userInfoDAO.getAllUser();
		// model.addAttribute("userData", userData);
		String[] paramList = subPageParam.split(" ");
		model.addAttribute("subPageParam", paramList[0]);
		if (paramList.length > 1) {
			model.addAttribute("subPageParam2", paramList[1]);
		} else {
			model.addAttribute("subPageParam2", "null");
		}
		return "userManager";
	}

	@RequestMapping("/lienhe")
	public String lienhe(Model model) {

		model.addAttribute("hoàn tất!", "HẠ TẦNG TRUYỀN DẪN");

		return "lienhe";

	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You have permission to access this page!");
		}
		return "403Page";
	}

	@RequestMapping("/userView")
	public String ListUser(Model model) {
		// map den trang userView.jsp, gui theo userdata
		List<UserInfo> userData = userInfoDAO.getAllUser();
		model.addAttribute("userData", userData);
		return "userView";
	}

	private String formUserInfo(Model model, UserInfo userInfo) {
		model.addAttribute("userInfo", userInfo);
		if (userInfo.getUserName() == null) {
			model.addAttribute("formTitle", "Tạo Tài khoản người dùng");
		} else {
			model.addAttribute("formTitle", "Thay đổi thông tin tài khoản người dùng");
		}
		return "add_editUser";
	}

	@RequestMapping("/addUser")
	public String AddUser(Model model) {
		UserInfo userInfo = new UserInfo();
		return this.formUserInfo(model, userInfo);
	}

	@RequestMapping("/editUser")
	public String EditUser(Model model, @RequestParam("username") String username) {
		User user = this.userInfoDAO.findUser(username);
		UserInfo userInfo = convertUserToUserInfo(user);
		return this.formUserInfo(model, userInfo);
	}

	private UserInfo convertUserToUserInfo(User user) {
		UserInfo userInfo = new UserInfo();
		if (user != null) {
			userInfo.setUserName(user.getUsername());
			userInfo.setPassword(user.getPassword());
			userInfo.setHoten(user.getHoten());
			userInfo.setNgaysinh(user.getNgaysinh());
			userInfo.setLienhe(user.getLienhe());
			userInfo.setGioithieu(user.getGioithieu());
			userInfo.setLast_modify(user.getLast_modify());
		}
		return userInfo;
	}

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
		// Form mục tiêu
		Object target = dataBinder.getTarget();

		if (target == null) {
			return;
		}
		System.out.println("Target=" + target);

		if (target.getClass() == UserInfo.class) {
			dataBinder.setValidator(userValidator);
		}
	}

	@RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
	public String saveUserInfo(Model model, //
			@ModelAttribute("userInfo") UserInfo userInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		userInfo.setLast_modify(new Date());
		userInfo.setPassword("12345");
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return this.formUserInfo(model, userInfo);
		}

		this.userInfoDAO.saveUserInfo(userInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save Applicant Successful");

		return "redirect:/userManager?subPageParam=userView";

	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Model model, @RequestParam("username") String username) {
		System.out.println("xoa: " + username);
		if (username != null) {
			this.userInfoDAO.deleteUser(username);
		}
		return "redirect:/userManager?subPageParam=userView";
	}

	@RequestMapping("/addTuyencap")
	public String addTuyencap(Model model) {
		TuyencapInfo tuyencapInfo = new TuyencapInfo();
		return this.formTuyencapInfo(model, tuyencapInfo);
	}

	private String formTuyencapInfo(Model model, TuyencapInfo tuyencapInfo) {
		model.addAttribute("tuyencapInfo", tuyencapInfo);

		if (tuyencapInfo.getTuyen_cap_id() == 0) {
			model.addAttribute("formTitle", "Thêm tuyến cáp");
		} else {
			model.addAttribute("formTitle", "thay đổi thông tin tuyến cáp");
		}

		return "add_editTuyencap";
	}
}
