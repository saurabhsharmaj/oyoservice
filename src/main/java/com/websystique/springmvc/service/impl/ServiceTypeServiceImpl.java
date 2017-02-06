package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ServiceTypeDAO;
import com.websystique.springmvc.model.ServiceType;
import com.websystique.springmvc.service.ServiceTypeService;

@Service
@Transactional
public class ServiceTypeServiceImpl implements ServiceTypeService {

	private static final Logger logger = LoggerFactory.getLogger(ServiceTypeServiceImpl.class);
	
	@Autowired
	ServiceTypeDAO serviceTypeDAO;
	
	@Override
	public void addServiceType(ServiceType p) {
		serviceTypeDAO.addServiceType(p);
	}

	@Override
	public void updateServiceType(ServiceType p) {
		serviceTypeDAO.updateServiceType(p);
	}

	@Override
	public List<ServiceType> listServiceTypes() {
		return serviceTypeDAO.listServiceTypes();
	}

	@Override
	public ServiceType getServiceTypeById(int id) {
		return serviceTypeDAO.getServiceTypeById(id);
	}

	@Override
	public void removeServiceType(int id) {
		serviceTypeDAO.removeServiceType(id);
	}

}
