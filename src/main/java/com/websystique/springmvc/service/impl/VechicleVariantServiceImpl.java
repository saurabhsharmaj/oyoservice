package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.VechicleVariantDAO;
import com.websystique.springmvc.model.VechicleVariant;
import com.websystique.springmvc.service.VechicleVariantService;

@Service
@Transactional
public class VechicleVariantServiceImpl implements VechicleVariantService {

	private static final Logger logger = LoggerFactory.getLogger(VechicleVariantServiceImpl.class);
	
	@Autowired
	VechicleVariantDAO serviceTypeDAO;
	
	@Override
	public void addVechicleVariant(VechicleVariant p) {
		serviceTypeDAO.addVechicleVariant(p);
	}

	@Override
	public void updateVechicleVariant(VechicleVariant p) {
		serviceTypeDAO.updateVechicleVariant(p);
	}

	@Override
	public List<VechicleVariant> listVechicleVariants() {
		return serviceTypeDAO.listVechicleVariants();
	}

	@Override
	public VechicleVariant getVechicleVariantById(int id) {
		return serviceTypeDAO.getVechicleVariantById(id);
	}

	@Override
	public void removeVechicleVariant(int id) {
		serviceTypeDAO.removeVechicleVariant(id);
	}

	@Override
	public List<VechicleVariant> listVechicleVariants(Integer vechicleModalId) {
		return serviceTypeDAO.listVechicleVariants(vechicleModalId);
	}

}
