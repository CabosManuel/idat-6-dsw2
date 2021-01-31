package pe.idat.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.User;
import pe.idat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void insert(User user) 
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));		
		repository.save(user);		
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<User> findAll() {
		return (Collection<User>)repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		pe.idat.model.User userDb=this.findByUsername(username);
		
		if(userDb!=null)
		{
			Collection<GrantedAuthority> authorities=new ArrayList<>();			
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); //para las pruebas
			
			return new org.springframework.security.core.userdetails.User(userDb.getUsername(),
					                                                      userDb.getPassword(),
					                                                      authorities);
		}
		
		throw new UsernameNotFoundException("Username no existe.");
	}
}















