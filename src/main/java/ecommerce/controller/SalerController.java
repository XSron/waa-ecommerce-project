package ecommerce.controller;

import java.io.File;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.model.Orders;
import ecommerce.model.Product;
import ecommerce.model.User;
import ecommerce.service.CategoryService;
import ecommerce.service.OrderService;
import ecommerce.service.ProductService;
import ecommerce.service.UserService;

@Controller
@RequestMapping("/saler")
public class SalerController {
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/productlist")
	public String productList(Model model, Principal principal) {
		User user = userService.findUserByName(principal.getName());
		model.addAttribute("products", productService.findProductByUserId(user.getUserId()));
		return "seller/product-list";
	}
	
	@GetMapping("/product")
	public String productPage(@ModelAttribute Product product, Model model) {
		model.addAttribute("categories", categoryService.findAllCategory());
		return "seller/product";
	}
	
	@GetMapping("/editproduct/{productId}")
	public String editProduct(@PathVariable("productId") Long id, Model model) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("categories", categoryService.findAllCategory());
		return "seller/product";
	}
	
	@GetMapping("/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId") Long id, RedirectAttributes redirectAttribute, Principal principal) {
		//check in case there is an an order associate with this product
		List<Orders> orders = orderService.findOrderByProductId(id);
		if(orders.isEmpty()) 
			productService.deleteProductById(id);
		else {
			Product product = productService.findProductById(id);
			redirectAttribute.addFlashAttribute("error", "Product "+ product.getProductName() +" is already associated with orders so you cannot delete it!");
		}
		return "redirect:/saler/productlist";
	}
	
	@PostMapping("/product")
	public String postProduct(@Valid @ModelAttribute Product product, BindingResult result, Principal principal) throws Exception {
		if(result.hasErrors())
			return "seller/product";
		
		User user = userService.findUserByName(principal.getName());
		
		MultipartFile image = product.getTmpImage();
		if(image != null && !image.isEmpty())
			image.transferTo(new File(System.getProperty("user.dir") + "/src/main/resources/static/images/" + image.getOriginalFilename()));
		
		product.setImage(product.getTmpImage().getOriginalFilename());
		product.setUser(user);
		productService.saveProduct(product);
		return "redirect:/saler/productlist";
	}
}