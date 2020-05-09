package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	@GetMapping("/productdetail/{productId}")
	public String productDetail(@Param("productId") Long id, Model model) {
		model.addAttribute("product", productService.findProductById(id));
		return "product-detail";
	}
}
