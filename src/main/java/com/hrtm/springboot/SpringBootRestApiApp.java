package com.hrtm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/**
 * 
 * @author <a href="mailto:atul.mundaware@afourtech.com">atul.mundaware</a>
 * @version 1.0
 */

//@EnableResourceServer
@SpringBootApplication(scanBasePackages={"com.hrtm.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class SpringBootRestApiApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}
	
//	@Autowired
//	public void authonticationManager(AuthenticationManagerBuilder bulider , UserRepository userRepo) throws Exception{
//		bulider.userDetailsService(s -> new CustomUserDetails(userRepo.findByEmail(s)));
//	}
}
