package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ManufacturerTypeDAO;
import com.websystique.springmvc.model.ManufacturerType;
import com.websystique.springmvc.service.ManufacturerTypeService;

@Service
@Transactional
public class ManufacturerTypeServiceImpl implements ManufacturerTypeService {

	private static final Logger logger = LoggerFactory.getLogger(ManufacturerTypeServiceImpl.class);
	
	@Autowired
	ManufacturerTypeDAO serviceTypeDAO;
	
	@Override
	public void addManufacturerType(ManufacturerType p) {
		serviceTypeDAO.addManufacturerType(p);
	}

	@Override
	public void updateManufacturerType(ManufacturerType p) {
		serviceTypeDAO.updateManufacturerType(p);
	}

	@Override
	public List<ManufacturerType> listManufacturerTypes() {
		return serviceTypeDAO.listManufacturerTypes();
	}

	@Override
	public ManufacturerType getManufacturerTypeById(int id) {
		return serviceTypeDAO.getManufacturerTypeById(id);
	}

	@Override
	public void removeManufacturerType(int id) {
		serviceTypeDAO.removeManufacturerType(id);
	}

	@Override
	public List<ManufacturerType> listManufacturerTypes(Integer vechicleType) {
		return serviceTypeDAO.listManufacturerTypes(vechicleType);
	}

}
