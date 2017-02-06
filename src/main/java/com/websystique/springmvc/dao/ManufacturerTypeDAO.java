package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.ManufacturerType;

public interface ManufacturerTypeDAO {
	public void addManufacturerType(ManufacturerType p);

	public void updateManufacturerType(ManufacturerType p);

	public List<ManufacturerType> listManufacturerTypes();

	public ManufacturerType getManufacturerTypeById(int id);

	public void removeManufacturerType(int id);

	public List<ManufacturerType> listManufacturerTypes(Integer vechicleType);
}
