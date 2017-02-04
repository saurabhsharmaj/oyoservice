package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phstudy.sample.dao.BookVechicleServiceDAO;
import org.phstudy.sample.model.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookVechicleServiceDAOImpl implements BookVechicleServiceDAO {

	private static final Logger logger = LoggerFactory.getLogger(BookVechicleServiceDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addBookService(BookService p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBookService(BookService p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookService> listBookServices() {
		Session session = sessionFactory.getCurrentSession();
		List<BookService> serviceTypeList = session.createQuery("from BookService").list();		
		return serviceTypeList;
	}

	@Override
	public BookService getBookServiceById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBookService(int id) {
		// TODO Auto-generated method stub
		
	}

}
