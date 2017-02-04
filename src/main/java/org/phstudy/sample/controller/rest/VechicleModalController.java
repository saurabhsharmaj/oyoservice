package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.VechicleModal;
import org.phstudy.sample.service.VechicleModalService;
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
public class VechicleModalController {

	private static final Logger logger = LoggerFactory
			.getLogger(VechicleModalController.class);

	@Autowired
	VechicleModalService serviceModalService;
	
	@RequestMapping(value = "/rest/vechiclemodals", method = RequestMethod.GET)
	public String serviceModals() {
		List<VechicleModal> serviceModals = serviceModalService.listVechicleModals();
		JsonArray array = new JsonArray();
		for (VechicleModal serviceModal : serviceModals) {
			array.add(toJson(serviceModal));
		}
		return array.toString();
	}

	@RequestMapping(value = "/rest/vechiclemodal/{manufacturerId}", method = RequestMethod.GET)
	public String serviceTypes(@PathVariable Integer manufacturerId) {
		List<VechicleModal> serviceModals = serviceModalService.listVechicleModals(manufacturerId);
		JsonArray array = new JsonArray();
		for (VechicleModal serviceModal : serviceModals) {
			array.add(toJson(serviceModal));
		}
		return array.toString();
	}
	
	private JsonElement toJson(VechicleModal serviceModal) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceModal.getId());
		jsonObject.addProperty("vechicleModal", serviceModal.getModalname());
		jsonObject.addProperty("vechicleName", serviceModal.getImage());
		return jsonObject;
	}
}
