package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import ecommerce.model.Product;
import ecommerce.service.ProductService;

@Controller
@SessionAttributes({"cart"})
public class HomeController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("products", productService.findAllProduct());
		return "index";
	}
	
	@SuppressWarnings("unchecked")
	@ModelAttribute
	public void totalCart(Model model) {
		List<Product> products = new ArrayList<>();
		if(model.getAttribute("cart") != null) 
			products = (List<Product>) model.getAttribute("cart");
		model.addAttribute("totalcart", products.size());
	}
}
