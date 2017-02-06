package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.BookVechicleServiceDAO;
import com.websystique.springmvc.model.BookService;
import com.websystique.springmvc.service.BookVechicleService;

@Service
@Transactional
public class BookVechicleServiceImpl implements BookVechicleService {

	private static final Logger logger = LoggerFactory.getLogger(BookVechicleServiceImpl.class);
	
	@Autowired
	BookVechicleServiceDAO serviceTypeDAO;
	
	@Override
	public void addBookService(BookService p) {
		serviceTypeDAO.addBookService(p);
	}

	@Override
	public void updateBookService(BookService p) {
		serviceTypeDAO.updateBookService(p);
	}

	@Override
	public List<BookService> listBookServices() {
		return serviceTypeDAO.listBookServices();
	}

	@Override
	public BookService getBookServiceById(int id) {
		return serviceTypeDAO.getBookServiceById(id);
	}

	@Override
	public void removeBookService(int id) {
		serviceTypeDAO.removeBookService(id);
	}

}
