package org.phstudy.sample.service;

import java.util.List;

import org.phstudy.sample.model.VechicleModal;

public interface VechicleModalService {
	public void addVechicleModal(VechicleModal p);

	public void updateVechicleModal(VechicleModal p);

	public List<VechicleModal> listVechicleModals();

	public VechicleModal getVechicleModalById(int id);

	public void removeVechicleModal(int id);

	public List<VechicleModal> listVechicleModals(Integer manufacturerId);
}
