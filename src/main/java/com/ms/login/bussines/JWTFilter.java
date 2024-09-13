package com.ms.login.bussines;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.login.services.JWTService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class JWTFilter implements Filter {
	
	    @Autowired
	    private JWTService jwtService;

	    // Crear el logger para esta clase
	    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;
            String authHeader = httpRequest.getHeader("Authorization");
//	        
//	        Enumeration<String> authHeaders = httpRequest.getHeaderNames();
//	        Locale lg = httpRequest.getLocale();
//	        String Prueba = httpRequest.getRemoteUser();
	        


//	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//	            String token = authHeader.substring(7); // Eliminar "Bearer " del token
//
//	            logger.info("Recibiendo token: {}", token);
//
//	            // Extraer el username del token
//	            String username = jwtService.extractUsername(token);

	            // Validar el token
//	            if (jwtService.validateToken(new User(1L, "rrmayo", "1234", "admin"))) {
	                // Log del token válido
//	                logger.info("Token válido para usuario: {}", username);
            logger.info("Token válido para usuario");
	                chain.doFilter(request, response);
//	            } else {
//	                // Log del token inválido o expirado
//	                logger.warn("Token inválido o expirado para usuario: {}", username);
//	                HttpServletResponse httpResponse = (HttpServletResponse) response;
//	                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	                httpResponse.getWriter().write("Token expired or invalid. Please log in again.");
//	            }
//	        } else {
	            // Log cuando no se recibe token
//	            logger.warn("Token no encontrado en la solicitud");
//	            HttpServletResponse httpResponse = (HttpServletResponse) response;
//	            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//	            httpResponse.getWriter().write("Missing or invalid Authorization header.");
//	        }
	    }
}
