package ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.model.User;
import ecommerce.service.RoleService;
import ecommerce.service.UserService;

@Controller
public class AuthenticationController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/signup")
	public String signUp(@ModelAttribute User user, Model model) {
		model.addAttribute("roles", roleService.findAllRoleExceptAdmin());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@Valid @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors())
			return "signup";
		userService.saveCategory(user);
		return "redirect:/";
	}
}
