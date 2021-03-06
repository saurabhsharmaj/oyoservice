package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.VechicleModalDAO;
import com.websystique.springmvc.model.VechicleModal;
import com.websystique.springmvc.service.VechicleModalService;

@Service
@Transactional
public class VechicleModalServiceImpl implements VechicleModalService {

	private static final Logger logger = LoggerFactory.getLogger(VechicleModalServiceImpl.class);
	
	@Autowired
	VechicleModalDAO serviceModalDAO;
	
	@Override
	public void addVechicleModal(VechicleModal p) {
		serviceModalDAO.addVechicleModal(p);
	}

	@Override
	public void updateVechicleModal(VechicleModal p) {
		serviceModalDAO.updateVechicleModal(p);
	}

	@Override
	public List<VechicleModal> listVechicleModals() {
		return serviceModalDAO.listVechicleModals();
	}

	@Override
	public VechicleModal getVechicleModalById(int id) {
		return serviceModalDAO.getVechicleModalById(id);
	}

	@Override
	public void removeVechicleModal(int id) {
		serviceModalDAO.removeVechicleModal(id);
	}

	@Override
	public List<VechicleModal> listVechicleModals(Integer manufacturerId) {
		return serviceModalDAO.listVechicleModals(manufacturerId);
	}

}
