package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.phstudy.sample.dao.UserDAO;
import org.phstudy.sample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addUser(User p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> serviceTypeList = session.createQuery("from User").list();		
		return serviceTypeList;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findByEmail(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(User.class);	
		c.add( Restrictions.eq("email", username) );
		return (User) c.uniqueResult();
	
	}

}
