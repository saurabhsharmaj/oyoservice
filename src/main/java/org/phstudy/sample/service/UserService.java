package org.phstudy.sample.service;

import java.util.List;

import org.phstudy.sample.exception.DuplicateEmailException;
import org.phstudy.sample.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

	public User loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public User registerNewUserAccount(User userAccountData) throws DuplicateEmailException;
	
	public void addUser(User p);

	public void updateUser(User p);

	public List<User> listUsers();

	public User getUserById(int id);

	public void removeUser(int id);
	
}
