package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/approveseller")
	public String approveSeller(Model model) {
		model.addAttribute("sellers", userService.findAllSeller());
		return "admin/approve-saler";
	}
	
	@GetMapping("/approveseller/{sellerId}")
	public String approveSeller(@PathVariable("sellerId") Integer id) {
		userService.approveSeller(id);
		return "redirect:/admin/approveseller";
	}
	
	@GetMapping("/approvereview")
	public String approveReview() {
		return "admin/approve-review";
	}
}
