package com.websystique.springmvc.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.websystique.springmvc.model.ManufacturerType;
import com.websystique.springmvc.service.ManufacturerTypeService;

@RestController
public class ManufacturerTypeController {

	private static final Logger logger = LoggerFactory
			.getLogger(ManufacturerTypeController.class);

	@Autowired
	ManufacturerTypeService serviceTypeService;
	
	@RequestMapping(value = "/rest/manufacturertypes", method = RequestMethod.GET)
	public String serviceTypes() {
		List<ManufacturerType> serviceTypes = serviceTypeService.listManufacturerTypes();
		JsonArray array = new JsonArray();
		for (ManufacturerType serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}
	
	@RequestMapping(value = "/rest/manufacturertype/{vechicleType}", method = RequestMethod.GET)
	public String serviceTypes(@PathVariable Integer vechicleType) {
		List<ManufacturerType> serviceTypes = serviceTypeService.listManufacturerTypes(vechicleType);
		JsonArray array = new JsonArray();
		for (ManufacturerType serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	private JsonElement toJson(ManufacturerType serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("logo", serviceType.getLogo());
		jsonObject.addProperty("name", serviceType.getName());
		return jsonObject;
	}
}
