package ecommerce.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ecommerce.model.Product;
import ecommerce.model.ProductReview;
import ecommerce.model.User;
import ecommerce.service.ProductReviewService;
import ecommerce.service.ProductService;
import ecommerce.service.UserService;

@Controller
@SessionAttributes({"cart"})
public class HomeController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductReviewService productReviewService;
	@Autowired 
	private UserService userService;
	
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
	
	@GetMapping("/productdetail/{productId}")
	public String productDetail(@PathVariable("productId") Long id, Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("review", new ProductReview());
		return "buyer/product-detail";
	}
	
	@PostMapping("/reviewproduct/{productId}")
	public String reviewProduct(@ModelAttribute("review") ProductReview productReview, @PathVariable("productId") Long id, Principal principal) {
		User user = userService.findUserByName(principal.getName());
		productReview.setProduct(productService.findProductById(id));
		productReview.setReviewBy(user);
		productReviewService.review(productReview);
		return "redirect:/";
	}
}
