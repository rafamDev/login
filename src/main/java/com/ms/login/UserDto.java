package com.ms.login;


public class UserDto{

	private User user;
	
	private UserEntity userEntity;

	public UserDto(UserEntity entity) {
		super();
		this.userEntity = entity;
		this.user = new User();
		this.user.setId(this.userEntity.getId());
		this.user.setUsername(this.userEntity.getUsername());
		this.user.setPassword(this.userEntity.getPassword());
		this.user.setRole(this.userEntity.getRole());
	}
	
	public UserDto(User user) {
		super();
		this.user = user;
		this.userEntity = new UserEntity();
		this.userEntity.setId(this.user.getId());
		this.userEntity.setUsername(this.user.getUsername());
		this.userEntity.setPassword(this.user.getPassword());
		this.userEntity.setRole(this.user.getRole());
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

    
}
