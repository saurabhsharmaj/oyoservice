package org.phstudy.sample.controller.rest;

import java.util.List;

import org.phstudy.sample.model.User;
import org.phstudy.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	UserService serviceTypeService;
	
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET)
	public String serviceTypes() {
		List<User> serviceTypes = serviceTypeService.listUsers();
		JsonArray array = new JsonArray();
		for (User serviceType : serviceTypes) {
			array.add(toJson(serviceType));
		}
		return array.toString();
	}

		
	private JsonElement toJson(User serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("email", serviceType.getEmail());
		jsonObject.addProperty("firstname", serviceType.getFirstName());
		jsonObject.addProperty("lastname", serviceType.getLastName());
		jsonObject.addProperty("password", serviceType.getPassword());
		jsonObject.addProperty("role", serviceType.getRole().name());	
		jsonObject.addProperty("signInProvider", serviceType.getSignInProvider().name());	
		return jsonObject;
	}
}
