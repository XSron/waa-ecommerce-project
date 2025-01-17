package ecommerce.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("SELECT username, password, is_enable as ENABLED FROM user WHERE username = ?")
			.authoritiesByUsernameQuery("SELECT username, role_name as authority FROM USER U INNER JOIN ROLE R ON U.ROLE_ID = R.ROLE_ID WHERE username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/saler/**").hasRole("SELLER")
			.antMatchers("/buyer/**").hasRole("BUYER")
			.and()
			.formLogin().loginPage("/login")
						//.usernameParameter("").passwordParameter("") //custom input type name
						.permitAll()
			.and()
			.logout()
			.deleteCookies("JSESSIONID") //clear remember me
			.logoutSuccessUrl("/?logout=true")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
			.rememberMe().rememberMeParameter("remember-me").key("HELLOWORLD");
		
		//for accessing h2 db	
		//http.csrf().disable();
		//http.headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
