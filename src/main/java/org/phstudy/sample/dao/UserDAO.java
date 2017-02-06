package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.User;

public interface UserDAO {
	public void addUser(User p);

	public void updateUser(User p);

	public List<User> listUsers();

	public User getUserById(int id);

	public void removeUser(int id);
	
	public User findByEmail(String username);
}
