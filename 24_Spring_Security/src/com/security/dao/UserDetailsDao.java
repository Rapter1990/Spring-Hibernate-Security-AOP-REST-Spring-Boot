package com.security.dao;

import com.security.entity.User;

public interface UserDetailsDao {

	User findUserByUsername(String username);
}
