package ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.model.User;
import ecommerce.service.OrderService;
import ecommerce.service.UserService;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
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
}
