package com.websystique.springmvc.controller.rest;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserService;

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
		System.out.println(array.toString());
		return array.toString();
	}

		
	private JsonElement toJson(User serviceType) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", serviceType.getId());
		jsonObject.addProperty("email", serviceType.getEmail());
		jsonObject.addProperty("firstname", serviceType.getFirstName());
		jsonObject.addProperty("lastname", serviceType.getLastName());
		jsonObject.addProperty("password", serviceType.getPassword());
//		jsonObject.addProperty("role", listToString(serviceType.getUserProfiles()));		
		return jsonObject;
	}


	private String listToString(Set<UserProfile> userProfiles) {
		StringBuffer sb = new StringBuffer();
		if(userProfiles!=null)
		for (UserProfile userProfile : userProfiles) {
			if(sb.length() ==0)
				sb.append(userProfile.getType());
			else 
				sb.append(",").append(userProfile.getType());
		}
		return sb.toString();
	}
}
