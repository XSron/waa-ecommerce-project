package ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/hello")
	public String adminPage() {
		System.out.println("ADMIN");
		return "approve-review";
	}
}
