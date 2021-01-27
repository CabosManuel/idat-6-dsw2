package com.cabos.service;

import com.cabos.model.User;
import com.cabos.repository.UserRepository;

interface UserService extends UserRepository{
	
	User findByUsernameAndPassword(String username, String password);
}
