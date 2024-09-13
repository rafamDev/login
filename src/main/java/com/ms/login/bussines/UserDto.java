package com.ms.login.bussines;

import java.io.Serializable;

import com.ms.login.entities.UserEntity;

/**
 * Class used as a POJO in order to transform both entity and business object data related to user. 
 * 
 * @author rafamDev
 *
 */
public class UserDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private UserEntity userEntity;

	public UserDto(final UserEntity entity) {
		super();
		this.user = new User();
		this.user.setId(entity.getId());
		this.user.setUsername(entity.getUsername());
		this.user.setPassword(entity.getPassword());
		this.user.setRole(entity.getRole());
	}
	
	public UserDto(final User user) {
		super();
		this.userEntity = new UserEntity();
		this.userEntity.setId(user.getId());
		this.userEntity.setUsername(user.getUsername());
		this.userEntity.setPassword(user.getPassword());
		this.userEntity.setRole(user.getRole());
	}

	public User getUser() {
		return user;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}
 
}
