package com.ms.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	 private static Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
	
	 @Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http){
		    return getFreeAccessToEndPoint(http);
	 }

     private SecurityFilterChain getFreeAccessToEndPoint(HttpSecurity http) {
    	   try {
    		   return http.authorizeHttpRequests()
                       .anyRequest().permitAll()
                       .and()
                       .httpBasic()
                       .and()
                       .csrf().disable()
                       .build();

           } catch (Exception e) {
               LOG.error("Security error in login access{}", e);
           }
       return null;
	 }
       
	 
}		
 
	