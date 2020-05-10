package ecommerce.controller;

import java.security.Principal;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ecommerce.model.OrderDetail;
import ecommerce.model.Product;
import ecommerce.model.User;
import ecommerce.service.AddressService;
import ecommerce.service.OrderService;
import ecommerce.service.PaymentService;
import ecommerce.service.ProductService;
import ecommerce.service.UserService;

@Controller
@RequestMapping("/buyer")
@SessionAttributes({"cart"})
public class BuyerController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/history")
	public String orderHistory(Model model, Principal principal) {
		User user = userService.findUserByName(principal.getName());
		model.addAttribute("orders", orderService.findOrderByBuyerId(user.getUserId()));
		return "buyer/history";
	}
	
	@GetMapping("/detailorder/{orderId}")
	public String orderDetail(@PathVariable("orderId") Long id, Model model) {
		model.addAttribute("orders", orderService.findOrderById(id));
		model.addAttribute("total", orderService.findTotalOrderAmountByOrderId(id));
		return "buyer/history-detail";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/addtocart/{productId}")
	public String addToCart(@PathVariable("productId") Long id, Model model, RedirectAttributes redirectAttributes) {
		List<Product> products = new ArrayList<>();
		if(model.getAttribute("cart") != null) 
			products = (List<Product>) model.getAttribute("cart");
		
		Product product = null;
		if(products.size() > 0)
			product = products.stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
			if(product == null) {
				product = productService.findProductById(id);
				product.setQty(1);
				products.add(product);
			} else 
				product.setQty(product.getQty() + 1);
		model.addAttribute("cart", products);
		redirectAttributes.addFlashAttribute("totalcart", products.size());
		return "redirect:/";
	}
	
	@GetMapping("/mycart")
	public String mycart() {
		return "buyer/mycart";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/removeproduct/{productId}")
	public String removeFromCart(@PathVariable("productId") Long id, Model model) {
		List<Product> products = new ArrayList<>();
		if(model.getAttribute("cart") != null) 
			products = (List<Product>) model.getAttribute("cart");
		products.removeIf(x -> x.getProductId() == id);
		return "redirect:/buyer/mycart";
	}
	
	@GetMapping("/payment")
	public String payment(Model model, Principal principal) {
		User user = userService.findUserByName(principal.getName());
		model.addAttribute("user", user);
		return "buyer/payment";
	}
	
	@PostMapping("/updatepayment")
	public String updatePayment(@Valid @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors())
			return "buyer/payment";
		paymentService.savePayment(user.getPayment());
		return "redirect:/buyer/payment";
	}
	
	@GetMapping("/billingaddress")
	public String address(Model model, Principal principal) {
		User user = userService.findUserByName(principal.getName());
		model.addAttribute("user", user);
		return "buyer/billing-address";
	}
	
	@PostMapping("/updatebillingaddress")
	public String updateBillingUpdate(@Valid @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors())
			return "buyer/billingaddress";
		addressService.saveAddress(user.getAddress());
		return "redirect:/buyer/billingaddress";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/placeorder")
	public String placeOrder(Model model) {
		List<Product> products = new ArrayList<>();
		if(model.getAttribute("cart") != null) 
			products = (List<Product>) model.getAttribute("cart");
		List<OrderDetail> orderDetails = new ArrayList<>();
		if(products.size() > 0) {
			//for(Product p: products)
				//orderDetails.add(new OrderDetail(product, qty))
		}
		return "";
	}
}
