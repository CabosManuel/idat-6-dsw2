package com.cabos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cabos.model.User;

public interface UserRepository extends CrudRepository<com.cabos.model.User, Integer> {

	@Query(value = "select * from users where username=?", nativeQuery = true)
	public User findByUsername(String username);
}
