package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.VechicleModal;

public interface VechicleModalDAO {
	public void addVechicleModal(VechicleModal p);

	public void updateVechicleModal(VechicleModal p);

	public List<VechicleModal> listVechicleModals();

	public VechicleModal getVechicleModalById(int id);

	public void removeVechicleModal(int id);
}
