package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.VechicleModal;

public interface VechicleModalDAO {
	public void addVechicleModal(VechicleModal p);

	public void updateVechicleModal(VechicleModal p);

	public List<VechicleModal> listVechicleModals();

	public VechicleModal getVechicleModalById(int id);

	public void removeVechicleModal(int id);

	public List<VechicleModal> listVechicleModals(Integer manufacturerId);
}
