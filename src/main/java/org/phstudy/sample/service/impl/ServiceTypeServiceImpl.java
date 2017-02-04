package org.phstudy.sample.service.impl;

import java.util.List;

import org.phstudy.sample.dao.ServiceTypeDAO;
import org.phstudy.sample.model.ServiceType;
import org.phstudy.sample.service.ServiceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
