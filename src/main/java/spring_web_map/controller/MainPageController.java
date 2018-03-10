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

import spring_web_map.dao.HamcapInfoDAO;
import spring_web_map.dao.PointInfoDAO;
import spring_web_map.dao.TuyencapInfoDAO;
import spring_web_map.dao.UserInfoDAO;
import spring_web_map.entity.Hamcap;
import spring_web_map.entity.Point;
import spring_web_map.entity.Tuyencap;
import spring_web_map.entity.User;
import spring_web_map.model.HamcapInfo;
import spring_web_map.model.PointInfo;
import spring_web_map.model.TuyencapInfo;
import spring_web_map.model.UserInfo;
import spring_web_map.validator.UserValidator;

@Controller
@Transactional
@EnableWebMvc
public class MainPageController {

	@Autowired
	UserInfoDAO userInfoDAO;
	@Autowired
	private PointInfoDAO pointInfoDAO;
	@Autowired
	private HamcapInfoDAO hamcapInfoDAO;

	@Autowired
	private TuyencapInfoDAO tuyencapInfoDAO;

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
	public String thietbi_cauhinh(Model model, @RequestParam("subPageParam") String subPageParam) {

		model.addAttribute("hoàn tất!", "HẠ TẦNG TRUYỀN DẪN");
		String[] paramList = subPageParam.split(" ");
		model.addAttribute("subPageParam", paramList[0]);
		if (paramList.length > 1) {
			model.addAttribute("subPageParam2", paramList[1]);
		} else {
			model.addAttribute("subPageParam2", "null");
		}
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
		// String userName = principal.getName();

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

	// tuyen cap srvlet
	@RequestMapping("/addTuyencap")
	public String addTuyencap(Model model) {
		TuyencapInfo tuyencapInfo = new TuyencapInfo();
		return this.formTuyencapInfo(model, tuyencapInfo);
	}

	@RequestMapping("/editTuyencap")
	public String EditUser(Model model, @RequestParam("Tuyencap_id") int Tuyencap_id) {
		Tuyencap Tuyencap = this.tuyencapInfoDAO.findTuyencap(Tuyencap_id);
		System.out.println("edit:" + Tuyencap.toString());
		TuyencapInfo TuyencapInfo = convertTuyencapToTuyencapInfo(Tuyencap);
		return this.formTuyencapInfo(model, TuyencapInfo);
	}

	private TuyencapInfo convertTuyencapToTuyencapInfo(Tuyencap Tuyencap) {
		TuyencapInfo TuyencapInfo = new TuyencapInfo();
		if (Tuyencap != null) {
			TuyencapInfo.setTuyen_cap_id(Tuyencap.getTuyen_cap_id());
			TuyencapInfo.setTen_tuyen_cap(Tuyencap.getTen_tuyen_cap());
			TuyencapInfo.setChieu_dai_tuyen_cap(Tuyencap.getChieu_dai_tuyen_cap());
			TuyencapInfo.setSo_core(Tuyencap.getSo_core());
			TuyencapInfo.setVi_tri_diem_dau_id(Tuyencap.getVi_tri_diem_dau_id());
			TuyencapInfo.setVi_tri_diem_cuoi_id(Tuyencap.getVi_tri_diem_cuoi_id());
			TuyencapInfo.setMo_ta_tuyen_cap(Tuyencap.getMo_ta_tuyen_cap());
		}
		return TuyencapInfo;
	}

	private String formTuyencapInfo(Model model, TuyencapInfo TuyencapInfo) {
		model.addAttribute("tuyencapInfo", TuyencapInfo);

		if (TuyencapInfo.getTuyen_cap_id() == 0) {
			model.addAttribute("formTitle", "Thêm Tuyến cáp");
			model.addAttribute("mode", "add");
		} else {
			model.addAttribute("formTitle", "thay đổi thông tin Tuyến cáp");
			model.addAttribute("mode", "edit");
		}

		return "add_editTuyencap";
	}

	@RequestMapping(value = "/saveTuyencapInfo", method = RequestMethod.POST)
	public String saveTuyencapInfo(Model model, //
			@ModelAttribute("TuyencapInfo") TuyencapInfo TuyencapInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		System.out.println("Hầm cáp: " + TuyencapInfo.toString());
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return this.formTuyencapInfo(model, TuyencapInfo);
		}

		this.tuyencapInfoDAO.saveTuyencapInfo(TuyencapInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save Applicant Successful");

		return "redirect:/thietbi_cauhinh?subPageParam=tuyencapView";
	}

	@RequestMapping("/tuyencapView")
	public String ListTuyencap(Model model) {
		// map den trang userView.jsp, gui theo userdata
		List<TuyencapInfo> TuyencapData = tuyencapInfoDAO.getAllTuyencap();
		model.addAttribute("tuyencapData", TuyencapData);
		return "tuyencapView";
	}

	@RequestMapping("/deleteTuyencap")
	public String deleteTuyencap(Model model, @RequestParam("tuyencap_id") int tuyencap_id) {
		System.out.println("xoa: " + tuyencap_id);
		if (tuyencap_id >= 0) {
			this.tuyencapInfoDAO.deleteTuyencap(tuyencap_id);
		}
		return "redirect:/thietbi_cauhinh?subPageParam=tuyencapView";
	}
	// page vi tri cua ham svl

	@RequestMapping("/vitriCuaham")
	public String vitriCuaham(Model model) {
		// map den trang userView.jsp, gui theo userdata
		List<HamcapInfo> hamcapData = hamcapInfoDAO.getAllHamcap();
		model.addAttribute("hamcapData", hamcapData);
		List<PointInfo> pointData = pointInfoDAO.getAllPoint();
		model.addAttribute("pointData", pointData);
		return "vitriCuaham";
	}

	// hamcap servlet
	@RequestMapping("/addHamcap")
	public String addHamcap(Model model) {
		HamcapInfo hamcapInfo = new HamcapInfo();
		return this.formHamcapInfo(model, hamcapInfo);
	}

	@RequestMapping("/editHamcap")
	public String EditHamcap(Model model, @RequestParam("hamcap_id") int Hamcap_id) {
		Hamcap Hamcap = this.hamcapInfoDAO.findHamcap(Hamcap_id);
		System.out.println("edit:" + Hamcap.toString());
		HamcapInfo HamcapInfo = convertHamcapToHamcapInfo(Hamcap);
		return this.formHamcapInfo(model, HamcapInfo);
	}

	private HamcapInfo convertHamcapToHamcapInfo(Hamcap Hamcap) {
		HamcapInfo HamcapInfo = new HamcapInfo();
		if (Hamcap != null) {
			HamcapInfo.setHam_cap_id(Hamcap.getHam_cap_id());
			HamcapInfo.setTen_ham_cap(Hamcap.getTen_ham_cap());
			HamcapInfo.setTreo_ngam(Hamcap.getTreo_ngam());
			HamcapInfo.setVi_tri_id(Hamcap.getVi_tri_id());
		}
		return HamcapInfo;
	}

	private String formHamcapInfo(Model model, HamcapInfo HamcapInfo) {
		model.addAttribute("hamcapInfo", HamcapInfo);

		if (HamcapInfo.getHam_cap_id() == 0) {
			model.addAttribute("formTitle", "Thêm Vị trí hầm cáp");
			model.addAttribute("mode", "add");
		} else {
			model.addAttribute("formTitle", "thay đổi thông tin Vị trí hầm cáp");
			model.addAttribute("mode", "edit");
		}

		return "add_editHamcap";
	}

	@RequestMapping(value = "/saveHamcapInfo", method = RequestMethod.POST)
	public String saveHamcapInfo(Model model, //
			@ModelAttribute("hamcapInfo") HamcapInfo HamcapInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		System.out.println("Hầm cáp: " + HamcapInfo.toString());
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return this.formHamcapInfo(model, HamcapInfo);
		}

		this.hamcapInfoDAO.saveHamcapInfo(HamcapInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save Applicant Successful");

		return "redirect:/thietbi_cauhinh?subPageParam=hamcapView";
	}

	@RequestMapping("/hamcapView")
	public String ListHamcap(Model model) {
		// map den trang userView.jsp, gui theo userdata
		List<HamcapInfo> hamcapData = hamcapInfoDAO.getAllHamcap();
		model.addAttribute("hamcapData", hamcapData);
		return "hamcapView";
	}

	@RequestMapping("/deleteHamcap")
	public String deleteHamcap(Model model, @RequestParam("hamcap_id") int Hamcap_id) {
		System.out.println("xoa: " + Hamcap_id);
		if (Hamcap_id >= 0) {
			this.hamcapInfoDAO.deleteHamcap(Hamcap_id);
		}
		return "redirect:/thietbi_cauhinh?subPageParam=hamcapView";
	}

	// servlet Point
	@RequestMapping("/addPoint")
	public String addPoint(Model model) {
		PointInfo pointInfo = new PointInfo();
		return this.formPointInfo(model, pointInfo);
	}

	@RequestMapping("/editPoint")
	public String EditPoint(Model model, @RequestParam("point_id") int point_id) {
		Point point = this.pointInfoDAO.findPoint(point_id);
		PointInfo pointInfo = convertPointToPointInfo(point);
		return this.formPointInfo(model, pointInfo);
	}

	private PointInfo convertPointToPointInfo(Point point) {
		PointInfo pointInfo = new PointInfo();
		if (point != null) {
			pointInfo.setPoint_id(point.getPoint_id());
			pointInfo.setX_data(point.getX_data());
			pointInfo.setY_data(point.getY_data());
		}
		return pointInfo;
	}

	private String formPointInfo(Model model, PointInfo pointInfo) {
		model.addAttribute("pointInfo", pointInfo);

		if (pointInfo.getPoint_id() == 0) {
			model.addAttribute("formTitle", "Thêm Vị trí");
		} else {
			model.addAttribute("formTitle", "thay đổi Tọa độ Vị trí");
		}

		return "add_editPoint";
	}

	@RequestMapping(value = "/savePointInfo", method = RequestMethod.POST)
	public String savePointInfo(Model model, //
			@ModelAttribute("pointInfo") PointInfo pointInfo, //
			BindingResult result, //
			final RedirectAttributes redirectAttributes) {
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return this.formPointInfo(model, pointInfo);
		}

		this.pointInfoDAO.savePointInfo(pointInfo);

		// Important!!: Need @EnableWebMvc
		// Add message to flash scope
		redirectAttributes.addFlashAttribute("message", "Save Applicant Successful");

		return "redirect:/thietbi_cauhinh?subPageParam=pointView";
	}

	@RequestMapping("/pointView")
	public String ListPoint(Model model) {
		// map den trang userView.jsp, gui theo userdata
		List<PointInfo> userData = pointInfoDAO.getAllPoint();
		model.addAttribute("pointData", userData);
		return "pointView";
	}

	@RequestMapping("/deletePoint")
	public String deletePoint(Model model, @RequestParam("point_id") int point_id) {
		System.out.println("xoa: " + point_id);
		if (point_id >= 0) {
			this.pointInfoDAO.deletePoint(point_id);
		}
		return "redirect:/thietbi_cauhinh?subPageParam=pointView";
	}
}
