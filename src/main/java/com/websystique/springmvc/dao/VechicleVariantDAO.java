package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.VechicleVariant;

public interface VechicleVariantDAO {
	public void addVechicleVariant(VechicleVariant p);

	public void updateVechicleVariant(VechicleVariant p);

	public List<VechicleVariant> listVechicleVariants();

	public VechicleVariant getVechicleVariantById(int id);

	public void removeVechicleVariant(int id);

	public List<VechicleVariant> listVechicleVariants(Integer vechicleModalId);
}
