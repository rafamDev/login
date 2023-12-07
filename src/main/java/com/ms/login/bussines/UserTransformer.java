package com.ms.login.bussines;

import java.util.Optional;

public interface UserTransformer {

	Optional<User> getUserByName(final String username);
	
}
