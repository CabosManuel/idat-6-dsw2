package pe.idat.service;

import java.util.Collection;

import pe.idat.model.User;

public interface UserService 
{
	public abstract void insert(User user);
	public abstract Collection<User> findAll();
	
	public abstract User findByUsername(String username);	
}
