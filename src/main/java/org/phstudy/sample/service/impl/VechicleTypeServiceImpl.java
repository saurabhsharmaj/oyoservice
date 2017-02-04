package org.phstudy.sample.service.impl;

import java.util.List;

import org.phstudy.sample.dao.VechicleTypeDAO;
import org.phstudy.sample.model.VechicleType;
import org.phstudy.sample.service.VechicleTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VechicleTypeServiceImpl implements VechicleTypeService {

	private static final Logger logger = LoggerFactory.getLogger(VechicleTypeServiceImpl.class);
	
	@Autowired
	VechicleTypeDAO serviceTypeDAO;
	
	@Override
	public void addVechicleType(VechicleType p) {
		serviceTypeDAO.addVechicleType(p);
	}

	@Override
	public void updateVechicleType(VechicleType p) {
		serviceTypeDAO.updateVechicleType(p);
	}

	@Override
	public List<VechicleType> listVechicleTypes() {
		return serviceTypeDAO.listVechicleTypes();
	}

	@Override
	public VechicleType getVechicleTypeById(int id) {
		return serviceTypeDAO.getVechicleTypeById(id);
	}

	@Override
	public void removeVechicleType(int id) {
		serviceTypeDAO.removeVechicleType(id);
	}

}
