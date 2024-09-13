package com.ms.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ms.login.bussines.JWTFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

    @Autowired
    private JWTFilter jwtFilter;

	
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
//                       .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                       .build();
    		   
//    		   return http
//                       .csrf().disable() // Desactivar CSRF si no es necesario (en APIs es común desactivarlo)
//                       .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Sin sesiones
//                       .and()
//                       .authorizeHttpRequests()
//                           .antMatchers("/auth/login", "/auth/register").permitAll() // Endpoints públicos
//                           .anyRequest().authenticated() // Cualquier otro endpoint requiere autenticación
//                       .and()
//                       .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Agregar filtro JWT
//                       .build();

           } catch (Exception e) {
               LOG.error("Security error in login access {}", e);
           }
       return null;
	 }
       

//     // Configurar el gestor de autenticación
//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     // Proveer un PasswordEncoder, en este caso BCrypt para encriptar contraseñas
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
	 
}		
 
	