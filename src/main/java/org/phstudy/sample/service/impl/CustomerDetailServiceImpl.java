package org.phstudy.sample.service.impl;

import java.util.List;

import org.phstudy.sample.dao.CustomerDetailDAO;
import org.phstudy.sample.model.CustomerDetail;
import org.phstudy.sample.service.CustomerDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerDetailServiceImpl implements CustomerDetailService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailServiceImpl.class);
	
	@Autowired
	CustomerDetailDAO serviceTypeDAO;
	
	@Override
	public void addCustomerDetail(CustomerDetail p) {
		serviceTypeDAO.addCustomerDetail(p);
	}

	@Override
	public void updateCustomerDetail(CustomerDetail p) {
		serviceTypeDAO.updateCustomerDetail(p);
	}

	@Override
	public List<CustomerDetail> listCustomerDetails() {
		return serviceTypeDAO.listCustomerDetails();
	}

	@Override
	public CustomerDetail getCustomerDetailById(int id) {
		return serviceTypeDAO.getCustomerDetailById(id);
	}

	@Override
	public void removeCustomerDetail(int id) {
		serviceTypeDAO.removeCustomerDetail(id);
	}

}
