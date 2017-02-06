package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserService {



	
	public User findById(int id) ;

	public User findBySSO(String sso) ;

	public void saveUser(User user);

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user);

	
	public void deleteUserBySSO(String sso);

	public List<User> findAllUsers() ;

	public boolean isUserSSOUnique(Integer id, String sso);

	public List<User> listUsers();
	


}
