package com.ms.login.services;

import com.ms.login.bussines.User;

public interface JWTService {

	String generateToken(User user);
		
//	boolean validateToken(String token, User user);
//
//    String extractUsername(String token);

}
