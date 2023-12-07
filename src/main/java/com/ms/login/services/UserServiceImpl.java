package com.ms.login.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.login.bussines.UserAdapter;
import com.ms.login.facades.UserFacade;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserFacade userFacade;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username){
		return new UserAdapter(userFacade.findUserByName(username));
	}

	
}
