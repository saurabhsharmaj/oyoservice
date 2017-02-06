package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.VechicleVariantDAO;
import com.websystique.springmvc.model.VechicleVariant;

@Repository
public class VechicleVariantDAOImpl implements VechicleVariantDAO {

	private static final Logger logger = LoggerFactory.getLogger(VechicleVariantDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addVechicleVariant(VechicleVariant p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVechicleVariant(VechicleVariant p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VechicleVariant> listVechicleVariants() {
		Session session = sessionFactory.getCurrentSession();
		List<VechicleVariant> serviceTypeList = session.createQuery("from VechicleVariant").list();		
		return serviceTypeList;
	}

	@Override
	public VechicleVariant getVechicleVariantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVechicleVariant(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VechicleVariant> listVechicleVariants(Integer vechicleModalId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(VechicleVariant.class);	
		c.add( Restrictions.eq("vechicleModal.id", vechicleModalId) );
		return c.list();
	}

}
