package org.phstudy.sample.service;

import java.util.List;

import org.phstudy.sample.model.CustomerDetail;

public interface CustomerDetailService {
	public void addCustomerDetail(CustomerDetail p);

	public void updateCustomerDetail(CustomerDetail p);

	public List<CustomerDetail> listCustomerDetails();

	public CustomerDetail getCustomerDetailById(int id);

	public void removeCustomerDetail(int id);
}
