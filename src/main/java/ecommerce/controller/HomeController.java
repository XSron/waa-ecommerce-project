package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ecommerce.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("products", productService.findAllProduct());
		return "index";
	}
}
