package spring_web_map.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
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
	public String userManager(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("User Name: " + userName);
		List<UserInfo> userData = userInfoDAO.getAllUser();
		model.addAttribute("userData", userData);

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
			model.addAttribute("formTitle", "Create Applicant");
		} else {
			model.addAttribute("formTitle", "Edit Applicant");
		}

		return "add_editUser";
	}

	@RequestMapping("/addUser")
	public String AddUser(Model model) {
		UserInfo userInfo = new UserInfo();
		return this.formUserInfo(model, userInfo);
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
	public String saveApplicant(Model model, //
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

		return "redirect:/userView";

	}

	@RequestMapping("/deleteUser")
	public String deleteApplicant(Model model, @RequestParam("username") String username) {
		System.out.println("xoa: "+ username);
		if (username != null) {
			this.userInfoDAO.deleteUser(username);
		}
		return "redirect:/userView";
	}
}
