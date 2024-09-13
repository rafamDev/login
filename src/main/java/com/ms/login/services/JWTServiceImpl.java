package com.ms.login.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ms.login.bussines.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTServiceImpl implements JWTService{

	 private final String SECRET_KEY = "mySecretKey";
	    
	    // Crear el logger para esta clase
	    private static final Logger logger = LoggerFactory.getLogger(JWTService.class);

	    // Método para generar un token
	    public String generateToken(User user) {
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("id", user.getId());
	        claims.put("username", user.getUsername());
	        claims.put("role", user.getRole());

	        // Log de la creación del token
	        logger.info("Generando token para usuario: ID = {}, Username = {}, Role = {}", user.getId(), user.getUsername(), user.getRole());

	        return "{ " + user.getId() + " }, Username = { " + user.getUsername() + " } , Role = { " + user.getRole() + " }";
	        
//	        return Jwts.builder()
//	                .setClaims(claims) // Añadir los datos del usuario
//	                .setSubject(user.getUsername()) // Nombre del sujeto
//	                .setIssuedAt(new Date(System.currentTimeMillis())) // Fecha de creación
//	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2)) // Expiración del token (2 minutos)
////	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) //  Firmar con algoritmo HS256 y la clave secreta
////	                .compact();
	    }

//	    // Método para validar un token
//	    public boolean validateToken(final String token, final User user) {
//	        String username = extractUsername(token);
//
//	        boolean isValid = (username.equals(user.getUsername()) && !isTokenExpired(token));
//	        
//	        // Log de validación del token
//	        if (isValid) {
//	            logger.info("Token válido para usuario: ID = {}, Username = {}", user.getId(), user.getUsername());
//	        } else {
//	            logger.warn("Token inválido o expirado para usuario: Username = {}", user.getUsername());
//	        }
//
//	        return isValid;
//	    }
//
//	    // Extraer el username del token
//	    public String extractUsername(final String token) {//SECRET_KEY
//	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//	    }
//
//	    // Verificar si el token ha expirado
//	    private boolean isTokenExpired(final String token) {
//	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().before(new Date());
//	    }

}
