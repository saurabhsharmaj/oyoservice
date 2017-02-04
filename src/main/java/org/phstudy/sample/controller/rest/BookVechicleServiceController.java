package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.BookService;
import org.phstudy.sample.service.BookVechicleService;
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
public class BookVechicleServiceController {

	private static final Logger logger = LoggerFactory
			.getLogger(BookVechicleServiceController.class);

	@Autowired
	BookVechicleService serviceTypeService;
	
	@RequestMapping(value = "/rest/bookvechicleservice", method = RequestMethod.GET)
	public String serviceTypes() {
		List<BookService> serviceTypes = serviceTypeService.listBookServices();
		JsonArray array = new JsonArray();
		for (BookService serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

	private JsonElement toJson(BookService serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("vechicleType", serviceType.getVechicleType());
		jsonObject.addProperty("bookingdate", serviceType.getBookingdate());
		jsonObject.addProperty("bookingid", serviceType.getBookingId());
		jsonObject.addProperty("description", serviceType.getDescription());
		jsonObject.addProperty("deliveryTime", serviceType.getEstdeliveryTime());
		jsonObject.addProperty("modal", serviceType.getModel());		
		jsonObject.addProperty("status", serviceType.getStatus());
		jsonObject.addProperty("variant", serviceType.getVariant());
		return jsonObject;
	}
}
