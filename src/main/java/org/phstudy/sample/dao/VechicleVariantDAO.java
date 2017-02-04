package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.VechicleVariant;

public interface VechicleVariantDAO {
	public void addVechicleVariant(VechicleVariant p);

	public void updateVechicleVariant(VechicleVariant p);

	public List<VechicleVariant> listVechicleVariants();

	public VechicleVariant getVechicleVariantById(int id);

	public void removeVechicleVariant(int id);
}
