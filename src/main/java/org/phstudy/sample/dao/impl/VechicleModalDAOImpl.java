package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.phstudy.sample.dao.VechicleModalDAO;
import org.phstudy.sample.model.VechicleModal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VechicleModalDAOImpl implements VechicleModalDAO {

	private static final Logger logger = LoggerFactory.getLogger(VechicleModalDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addVechicleModal(VechicleModal p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVechicleModal(VechicleModal p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VechicleModal> listVechicleModals() {
		Session session = sessionFactory.getCurrentSession();
		List<VechicleModal> serviceModalList = session.createQuery("from VechicleModal").list();		
		return serviceModalList;
	}

	@Override
	public VechicleModal getVechicleModalById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeVechicleModal(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<VechicleModal> listVechicleModals(Integer manufacturerId) {		
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(VechicleModal.class);	
		c.add( Restrictions.eq("manufacturerType.id", manufacturerId) );
		return c.list();	

	}

}
