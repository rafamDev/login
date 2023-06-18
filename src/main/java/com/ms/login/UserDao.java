package com.ms.login;

import java.util.Optional;

public interface UserDao {

   Optional<UserEntity> findUserByName(String username);

}