package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.ServiceCenter;

public interface ServiceCenterDAO {
	public void addServiceCenter(ServiceCenter p);

	public void updateServiceCenter(ServiceCenter p);

	public List<ServiceCenter> listServiceCenters();

	public ServiceCenter getServiceCenterById(int id);

	public void removeServiceCenter(int id);
}
