package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.ServiceType;

public interface ServiceTypeDAO {
	public void addServiceType(ServiceType p);

	public void updateServiceType(ServiceType p);

	public List<ServiceType> listServiceTypes();

	public ServiceType getServiceTypeById(int id);

	public void removeServiceType(int id);
}
