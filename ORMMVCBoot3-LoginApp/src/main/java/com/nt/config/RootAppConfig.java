package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {PersistenceConfig.class,ServiceAppConfig.class,AOPConfig.class})
public class RootAppConfig {

}
