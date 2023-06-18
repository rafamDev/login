package com.ms.login;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:57727")
@RestController
@RequestMapping("api/v1")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		final Optional<String> userDetailsOptional = Optional
				.ofNullable(userService.
						loadUserByUsername(user.getUsername()).getUsername());

		return userDetailsOptional.map(userDetails -> ResponseEntity.ok(user))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}   
	
}
