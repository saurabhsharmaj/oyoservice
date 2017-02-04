package org.phstudy.sample.service.impl;

import java.util.List;

import org.phstudy.sample.dao.ServiceCenterDAO;
import org.phstudy.sample.model.ServiceCenter;
import org.phstudy.sample.service.ServiceCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceCenterServiceImpl implements ServiceCenterService {

	private static final Logger logger = LoggerFactory.getLogger(ServiceCenterServiceImpl.class);
	
	@Autowired
	ServiceCenterDAO serviceCenterDAO;
	
	@Override
	public void addServiceCenter(ServiceCenter p) {
		serviceCenterDAO.addServiceCenter(p);
	}

	@Override
	public void updateServiceCenter(ServiceCenter p) {
		serviceCenterDAO.updateServiceCenter(p);
	}

	@Override
	public List<ServiceCenter> listServiceCenters() {
		return serviceCenterDAO.listServiceCenters();
	}

	@Override
	public ServiceCenter getServiceCenterById(int id) {
		return serviceCenterDAO.getServiceCenterById(id);
	}

	@Override
	public void removeServiceCenter(int id) {
		serviceCenterDAO.removeServiceCenter(id);
	}

}
