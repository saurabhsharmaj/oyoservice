package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phstudy.sample.dao.ManufacturerTypeDAO;
import org.phstudy.sample.model.ManufacturerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManufacturerTypeDAOImpl implements ManufacturerTypeDAO {

	private static final Logger logger = LoggerFactory.getLogger(ManufacturerTypeDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addManufacturerType(ManufacturerType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateManufacturerType(ManufacturerType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ManufacturerType> listManufacturerTypes() {
		Session session = sessionFactory.getCurrentSession();
		List<ManufacturerType> serviceTypeList = session.createQuery("from ManufacturerType").list();		
		return serviceTypeList;
	}

	@Override
	public ManufacturerType getManufacturerTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeManufacturerType(int id) {
		// TODO Auto-generated method stub
		
	}

}
