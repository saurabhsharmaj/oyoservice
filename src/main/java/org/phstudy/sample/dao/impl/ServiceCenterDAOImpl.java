package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phstudy.sample.dao.ServiceCenterDAO;
import org.phstudy.sample.model.ServiceCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceCenterDAOImpl implements ServiceCenterDAO {

	private static final Logger logger = LoggerFactory.getLogger(ServiceCenterDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addServiceCenter(ServiceCenter p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateServiceCenter(ServiceCenter p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServiceCenter> listServiceCenters() {
		Session session = sessionFactory.getCurrentSession();
		List<ServiceCenter> serviceCenterList = session.createQuery("from ServiceCenter").list();
		for(ServiceCenter p : serviceCenterList){
			logger.info("service center List::"+p);
		}
		return serviceCenterList;
	}

	@Override
	public ServiceCenter getServiceCenterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeServiceCenter(int id) {
		// TODO Auto-generated method stub
		
	}

}
