package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.VechicleTypeDAO;
import com.websystique.springmvc.model.VechicleType;

@Repository
public class VechicleTypeDAOImpl implements VechicleTypeDAO {

	private static final Logger logger = LoggerFactory.getLogger(VechicleTypeDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addVechicleType(VechicleType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVechicleType(VechicleType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VechicleType> listVechicleTypes() {
		Session session = sessionFactory.getCurrentSession();
		List<VechicleType> serviceTypeList = session.createQuery("from VechicleType").list();		
		return serviceTypeList;
	}

	@Override
	public VechicleType getVechicleTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVechicleType(int id) {
		// TODO Auto-generated method stub
		
	}

}
