package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.ServiceType;
import org.phstudy.sample.service.ServiceTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class ServiceTypeController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceTypeController.class);

	@Autowired
	ServiceTypeService serviceTypeService;
	
	@RequestMapping(value = "/rest/servicetypes", method = RequestMethod.GET)
	public String serviceTypes() {
		List<ServiceType> serviceTypes = serviceTypeService.listServiceTypes();
		JsonArray array = new JsonArray();
		for (ServiceType serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	private JsonElement toJson(ServiceType serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("serviceType", serviceType.getServiceType());
		jsonObject.addProperty("description", serviceType.getDescription());
		return jsonObject;
	}
}
