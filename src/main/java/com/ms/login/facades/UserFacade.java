package com.ms.login.facades;

import java.util.Optional;

import com.ms.login.bussines.User;


public interface UserFacade {

	Optional<User> findUserByName(final String username);
}
