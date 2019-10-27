package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.config.AppConfig;

@SpringBootApplication
@Import({AppConfig.class})
public class OAuthTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthTestApplication.class, args);
	}
	
}
