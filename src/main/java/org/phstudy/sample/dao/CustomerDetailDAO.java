package org.phstudy.sample.dao;

import java.util.List;

import org.phstudy.sample.model.CustomerDetail;

public interface CustomerDetailDAO {
	public void addCustomerDetail(CustomerDetail p);

	public void updateCustomerDetail(CustomerDetail p);

	public List<CustomerDetail> listCustomerDetails();

	public CustomerDetail getCustomerDetailById(int id);

	public void removeCustomerDetail(int id);
}
