package com.ms.login;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAdapter implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

    public UserAdapter(User user) {
		this.user = user;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
	
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
       return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; 
    }

    @Override
    public boolean isEnabled() {
        return true; 
    }

}
