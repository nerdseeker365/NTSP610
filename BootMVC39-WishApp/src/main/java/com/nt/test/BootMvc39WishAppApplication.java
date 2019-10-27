package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

@SpringBootApplication
@Import({RootAppConfig.class,WebMvcAppConfig.class})
public class BootMvc39WishAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvc39WishAppApplication.class, args);
	} 

}
