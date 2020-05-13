package ecommerce.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.model.Address;
import ecommerce.model.Payment;
import ecommerce.model.User;
import ecommerce.service.RoleService;
import ecommerce.service.UserService;

@Controller
public class AuthenticationController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String signUp(@ModelAttribute User user, Model model) {
		model.addAttribute("roles", roleService.findAllRoleExceptAdmin());
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signUp(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("roles", roleService.findAllRoleExceptAdmin());
			return "signup";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setAddress(new Address());
		user.setPayment(new Payment());
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/access-denied")
	public String accessDeniedPage() {
		return "access-denied";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
