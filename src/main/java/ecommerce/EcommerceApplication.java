package ecommerce;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import ecommerce.model.Address;
import ecommerce.model.Category;
import ecommerce.model.OrderDetail;
import ecommerce.model.OrderStatus;
import ecommerce.model.Orders;
import ecommerce.model.Payment;
import ecommerce.model.Product;
import ecommerce.model.ProductReview;
import ecommerce.model.Role;
import ecommerce.model.User;
import ecommerce.service.CategoryService;
import ecommerce.service.OrderService;
import ecommerce.service.OrderStatusService;
import ecommerce.service.ProductReviewService;
import ecommerce.service.ProductService;
import ecommerce.service.RoleService;
import ecommerce.service.UserService;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderStatusService orderStatusService;
	@Autowired
	private ProductReviewService productReviewService;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Initial Role
		roleService.saveRole(new Role("ROLE_ADMIN"));
		roleService.saveRole(new Role("ROLE_BUYER"));
		roleService.saveRole(new Role("ROLE_SELLER"));
		
		//Initial User
		userService.saveUser(new User("ADMIN", passwordEncoder.encode("ADMIN"), new Role(1), true, true, new Address(), new Payment()));
		userService.saveUser(new User("SELLER1", passwordEncoder.encode("SELLER"), new Role(3), true, true, new Address(), new Payment()));
		userService.saveUser(new User("SELLER2", passwordEncoder.encode("SELLER"), new Role(3), true, false, new Address(), new Payment()));
		userService.saveUser(new User("SELLER3", passwordEncoder.encode("SELLER"), new Role(3), true, false, new Address(), new Payment()));
		userService.saveUser(new User("SELLER4", passwordEncoder.encode("SELLER"), new Role(3), true, false, new Address(), new Payment()));
		userService.saveUser(new User("BUYER", passwordEncoder.encode("BUYER"), new Role(2), true, true, new Address(), new Payment()));
		
		//Initial Category
		categoryService.saveCategory(new Category("DRINK"));
		categoryService.saveCategory(new Category("FOOD"));
		
		//Initial Product
		productService.saveProduct(new Product("COKE", 100, 7.8, new Category(1), new User(2), "ContextLoader VS DispatcherServlet.png"));
		productService.saveProduct(new Product("PEPSI", 200, 6.8, new Category(1), new User(2), "Controller Method Return Type.png"));
		productService.saveProduct(new Product("FANTA", 300, 5.8, new Category(1), new User(2), "Crossfield-Validation.png"));
		productService.saveProduct(new Product("COKE", 100, 7.8, new Category(1), new User(2), "ContextLoader VS DispatcherServlet.png"));
		productService.saveProduct(new Product("PEPSI", 200, 6.8, new Category(1), new User(2), "Controller Method Return Type.png"));
		productService.saveProduct(new Product("FANTA", 300, 5.8, new Category(1), new User(2), "Crossfield-Validation.png"));
		
		//Initial Order Status
		orderStatusService.saveOrderStatus(new OrderStatus("ORDERED"));
		orderStatusService.saveOrderStatus(new OrderStatus("SHIPPED"));
		orderStatusService.saveOrderStatus(new OrderStatus("ON-THE-WAY"));
		orderStatusService.saveOrderStatus(new OrderStatus("DELIVERED"));
		orderStatusService.saveOrderStatus(new OrderStatus("CANCELLED"));
		
		//Initial Order
		List<OrderDetail> odList = new ArrayList<OrderDetail>();
		
		OrderDetail od1 = new OrderDetail(new Product(1L, 6.7), 2); 
		OrderDetail od2 = new OrderDetail(new Product(2L, 6.5), 2);
		odList.add(od1); odList.add(od2);
		Orders order = new Orders(LocalDateTime.now(), odList, new User(6));
		od1.setOrder(order); od2.setOrder(order);
		order.setOrderDetail(odList);
		orderService.saveOrder(order);
		
		//Initial ProductReview
		productReviewService.review(new ProductReview(new Product(1L), "Good", new User(1)));
		productReviewService.review(new ProductReview(new Product(1L), "Good", new User(1)));
		productReviewService.review(new ProductReview(new Product(2L), "Bad", new User(2)));
	}

}
