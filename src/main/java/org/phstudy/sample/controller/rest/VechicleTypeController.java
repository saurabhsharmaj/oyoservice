package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.VechicleType;
import org.phstudy.sample.service.VechicleTypeService;
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
public class VechicleTypeController {

	private static final Logger logger = LoggerFactory
			.getLogger(VechicleTypeController.class);

	@Autowired
	VechicleTypeService serviceTypeService;
	
	@RequestMapping(value = "/rest/vechicletypes", method = RequestMethod.GET)
	public String serviceTypes() {
		List<VechicleType> serviceTypes = serviceTypeService.listVechicleTypes();
		JsonArray array = new JsonArray();
		for (VechicleType serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	private JsonElement toJson(VechicleType serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("vechicleType", serviceType.getType());
		jsonObject.addProperty("vechicleName", serviceType.getName());
		jsonObject.addProperty("description", serviceType.getDescription());
		return jsonObject;
	}
}
