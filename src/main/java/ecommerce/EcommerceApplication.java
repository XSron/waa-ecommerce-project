package ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ecommerce.model.Role;
import ecommerce.service.RoleService;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Init Role
		roleService.saveRole(new Role("ADMIN"));
		roleService.saveRole(new Role("BUYER"));
		roleService.saveRole(new Role("SELLER"));
	}

}
