package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.VechicleType;

public interface VechicleTypeDAO {
	public void addVechicleType(VechicleType p);

	public void updateVechicleType(VechicleType p);

	public List<VechicleType> listVechicleTypes();

	public VechicleType getVechicleTypeById(int id);

	public void removeVechicleType(int id);
}
