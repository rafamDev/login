package com.ms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserFacade userFacade;

	@Override
	public UserDetails loadUserByUsername(String username){
		return new UserAdapter(userFacade.findUserByName(username).orElse(new User()));
		
    }

	
}
