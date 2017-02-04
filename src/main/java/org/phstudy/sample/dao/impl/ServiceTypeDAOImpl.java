package org.phstudy.sample.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.phstudy.sample.dao.ServiceTypeDAO;
import org.phstudy.sample.model.ServiceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceTypeDAOImpl implements ServiceTypeDAO {

	private static final Logger logger = LoggerFactory.getLogger(ServiceTypeDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addServiceType(ServiceType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateServiceType(ServiceType p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ServiceType> listServiceTypes() {
		Session session = sessionFactory.getCurrentSession();
		List<ServiceType> serviceTypeList = session.createQuery("from ServiceType").list();		
		return serviceTypeList;
	}

	@Override
	public ServiceType getServiceTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeServiceType(int id) {
		// TODO Auto-generated method stub
		
	}

}
