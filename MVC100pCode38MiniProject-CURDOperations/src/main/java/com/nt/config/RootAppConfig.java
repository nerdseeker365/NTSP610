package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceAppConfig.class,PersistenceAppConfig.class,AopConfig.class})
public class RootAppConfig {

}
