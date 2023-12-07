package com.ms.login.facades;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ms.login.bussines.User;

import com.ms.login.bussines.UserTransformer;


@Component
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserTransformer userTransformer;

	@Override
	public Optional<User> findUserByName(final String username) {
        return  userTransformer.getUserByName(username);
    }

}
