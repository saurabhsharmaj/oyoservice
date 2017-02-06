package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.CustomerDetailDAO;
import com.websystique.springmvc.model.CustomerDetail;

@Repository
public class CustomerDetailDAOImpl implements CustomerDetailDAO {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addCustomerDetail(CustomerDetail p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomerDetail(CustomerDetail p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDetail> listCustomerDetails() {
		Session session = sessionFactory.getCurrentSession();
		List<CustomerDetail> serviceTypeList = session.createQuery("from CustomerDetail").list();		
		return serviceTypeList;
	}

	@Override
	public CustomerDetail getCustomerDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCustomerDetail(int id) {
		// TODO Auto-generated method stub
		
	}

}
