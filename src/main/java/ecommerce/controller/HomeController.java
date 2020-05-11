package ecommerce.controller;

import java.security.Principal;
import java.time.LocalDateTime;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.model.Follower;
import ecommerce.model.Product;
import ecommerce.model.ProductReview;
import ecommerce.model.User;
import ecommerce.service.FollowService;
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
	@Autowired
	private FollowService followerService;
	
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
	public String productDetail(@PathVariable("productId") Long id, Model model, Principal principal) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("review", new ProductReview());
		try {
			User user = userService.findUserByName(principal.getName());
			model.addAttribute("isBuyerBuyProduct", productService.isBuyerBuyProductById(id, user.getUserId()));
		}catch(Exception ex) {}
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
	
	@GetMapping("/sellerprofile/{sellerId}")
	public String sellerProfile(@PathVariable("sellerId") Integer id, Model model, Principal principal) {
		User seller = userService.findUserById(id);
		model.addAttribute("seller", seller);
		model.addAttribute("totalfollowers", followerService.countFollowerBySellerId(seller.getUserId()));
		
		boolean isFollow = false;
		try {
			User buyer = userService.findUserByName(principal.getName());
			isFollow = followerService.isFollow(seller.getUserId(), buyer.getUserId());
		}catch(Exception ex) {}
		model.addAttribute("isfollow", isFollow);
		return "seller-profile";
	}
	
	@GetMapping("/follow/{sellerId}")
	public String follow(@PathVariable("sellerId") Integer id, Principal principal, RedirectAttributes ra) {
		User seller = userService.findUserById(id);
		User buyer = userService.findUserByName(principal.getName());
		followerService.follow(new Follower(seller, buyer, LocalDateTime.now()));
		return "redirect:/sellerprofile/" + id;
	}
	
	@GetMapping("/unfollow/{sellerId}")
	public String unfollow(@PathVariable("sellerId") Integer id, Principal principal, RedirectAttributes ra) {
		User seller = userService.findUserById(id);
		User buyer = userService.findUserByName(principal.getName());
		followerService.unfollow(new Follower(seller, buyer, LocalDateTime.now()));
		return "redirect:/sellerprofile/" + id;
	}
}
