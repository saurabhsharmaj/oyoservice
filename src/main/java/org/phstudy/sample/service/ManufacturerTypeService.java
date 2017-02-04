package org.phstudy.sample.service;

import java.util.List;

import org.phstudy.sample.model.ManufacturerType;

public interface ManufacturerTypeService {
	public void addManufacturerType(ManufacturerType p);

	public void updateManufacturerType(ManufacturerType p);

	public List<ManufacturerType> listManufacturerTypes();

	public ManufacturerType getManufacturerTypeById(int id);

	public void removeManufacturerType(int id);

	public List<ManufacturerType> listManufacturerTypes(Integer vechicleType);
}
