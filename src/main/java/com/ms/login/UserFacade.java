package com.ms.login;

import java.util.Optional;

public interface UserFacade {

	Optional<User> findUserByName(String username);
}
