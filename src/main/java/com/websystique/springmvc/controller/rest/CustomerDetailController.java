package com.websystique.springmvc.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.websystique.springmvc.model.CustomerDetail;
import com.websystique.springmvc.service.CustomerDetailService;

@RestController
public class CustomerDetailController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerDetailController.class);

	@Autowired
	CustomerDetailService serviceTypeService;
	
	@RequestMapping(value = "/rest/customerdetail", method = RequestMethod.GET)
	public String serviceTypes() {
		List<CustomerDetail> serviceTypes = serviceTypeService.listCustomerDetails();
		JsonArray array = new JsonArray();
		for (CustomerDetail serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	private JsonElement toJson(CustomerDetail serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("firstname", serviceType.getFirstname());
		jsonObject.addProperty("lastname", serviceType.getLastname());
		jsonObject.addProperty("contactno", serviceType.getContactno());
		jsonObject.addProperty("emailId", serviceType.getEmailid());
		return jsonObject;
	}
}
