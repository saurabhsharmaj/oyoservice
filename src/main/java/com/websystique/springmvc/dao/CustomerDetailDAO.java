package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.CustomerDetail;

public interface CustomerDetailDAO {
	public void addCustomerDetail(CustomerDetail p);

	public void updateCustomerDetail(CustomerDetail p);

	public List<CustomerDetail> listCustomerDetails();

	public CustomerDetail getCustomerDetailById(int id);

	public void removeCustomerDetail(int id);
}
