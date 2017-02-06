package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.VechicleType;


public interface VechicleTypeService {
	public void addVechicleType(VechicleType p);

	public void updateVechicleType(VechicleType p);

	public List<VechicleType> listVechicleTypes();

	public VechicleType getVechicleTypeById(int id);

	public void removeVechicleType(int id);
}
