package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.VechicleVariant;
import org.phstudy.sample.service.VechicleVariantService;
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

@RestController
public class VechicleVariantController {

	private static final Logger logger = LoggerFactory
			.getLogger(VechicleVariantController.class);

	@Autowired
	VechicleVariantService serviceTypeService;
	
	@RequestMapping(value = "/rest/vechiclevariants", method = RequestMethod.GET)
	public String serviceTypes() {
		List<VechicleVariant> serviceTypes = serviceTypeService.listVechicleVariants();
		JsonArray array = new JsonArray();
		for (VechicleVariant serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	@RequestMapping(value = "/rest/vechiclevariants/{vechicleModalId}", method = RequestMethod.GET)
	public String serviceTypes(@PathVariable Integer vechicleModalId) {
		List<VechicleVariant> serviceTypes = serviceTypeService.listVechicleVariants(vechicleModalId);
		JsonArray array = new JsonArray();
		for (VechicleVariant serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}
	
	private JsonElement toJson(VechicleVariant serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("variantName", serviceType.getName());
		jsonObject.addProperty("description", serviceType.getDescription());
		return jsonObject;
	}
}
