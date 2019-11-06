package com.proacscent.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class DemoApplication {

	@Bean
	public BCryptPasswordEncoder encodePWD(){
		return  new BCryptPasswordEncoder();
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
