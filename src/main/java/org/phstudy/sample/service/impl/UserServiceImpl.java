package org.phstudy.sample.service.impl;

import java.util.List;

import org.phstudy.sample.dao.UserDAO;
import org.phstudy.sample.exception.DuplicateEmailException;
import org.phstudy.sample.model.User;
import org.phstudy.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	UserDAO userDAO;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDAO.findByEmail(username);

		logger.debug("Found user: {}", user);

		if (user == null) {
			throw new UsernameNotFoundException("No user found with username: " + username);
		}

		return user;
	}

	@Override
	public User registerNewUserAccount(User userAccountData) throws DuplicateEmailException {

		logger.debug("Registering new user account with information: {}", userAccountData);

		if (emailExist(userAccountData.getEmail())) {
			logger.debug("Email: {} exists. Throwing exception.", userAccountData.getEmail());
			throw new DuplicateEmailException(
					"The email address: " + userAccountData.getEmail() + " is already in use.");
		}

		logger.debug("Email: {} does not exist. Continuing registration.", userAccountData.getEmail());

		String encodedPassword = encodePassword(userAccountData);

		return userAccountData;

	}

	private boolean emailExist(String email) {
		logger.debug("Checking if email {} is already found from the database.", email);

		User user = userDAO.findByEmail(email);

		if (user != null) {
			logger.debug("User account: {} found with email: {}. Returning true.", user, email);
			return true;
		}

		logger.debug("No user account found with email: {}. Returning false.", email);

		return false;
	}

	private String encodePassword(User dto) {
		String encodedPassword = null;

		logger.debug("Registration is normal registration. Encoding password.");
		encodedPassword = passwordEncoder.encode(dto.getPassword());

		return encodedPassword;
	}

	@Override
	public void addUser(User p) {
		userDAO.addUser(p);
		
	}

	@Override
	public void updateUser(User p) {
		userDAO.updateUser(p);
	}

	@Override
	public List<User> listUsers() {		
		return userDAO.listUsers();
	}

	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void removeUser(int id) {
		userDAO.removeUser(id);
		
	}

}
