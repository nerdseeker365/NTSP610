package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
@Import(value={PersistenceConfig.class,ServiceConfig.class})
public class AppConfig {

}
