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
import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Country;
import com.websystique.springmvc.model.State;
import com.websystique.springmvc.service.CountryStateCityFilterService;

@RestController
public class CountryStateCityFilterController {

	private static final Logger logger = LoggerFactory
			.getLogger(CustomerDetailController.class);

	@Autowired
	CountryStateCityFilterService cscService;
	
	@RequestMapping(value = "/rest/countries", method = RequestMethod.GET)
	public String countries() {
		List<Country> countries = cscService.listCountries();
		JsonArray array = new JsonArray();
		for (Country country : countries) {
			array.add(toJson(country));
		}
		return array.toString();
	}

	private JsonElement toJson(Country country) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("countryId", country.getCountryId());
		jsonObject.addProperty("countryName", country.getCountryName());
		return jsonObject;
	}
	
	@RequestMapping(value = "/rest/states", method = RequestMethod.GET)
	public String states() {
		List<State> states = cscService.listStates();
		JsonArray array = new JsonArray();
		for (State state : states) {
			array.add(toJson(state));
		}
		return array.toString();
	}
	
	@RequestMapping(value = "/rest/states/{countryId}", method = RequestMethod.GET)
	public String states(@PathVariable Long countryId) {
		List<State> states = cscService.listStateByCountry(countryId);
		JsonArray array = new JsonArray();
		for (State state : states) {
			array.add(toJson(state));
		}
		return array.toString();
	}
	private JsonElement toJson(State state) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("stateId", state.getStateId());
		jsonObject.addProperty("stateName", state.getStateName());
		jsonObject.addProperty("countryId", state.getCountry().getCountryId());
		return jsonObject;
	}
	
	@RequestMapping(value = "/rest/cities", method = RequestMethod.GET)
	public String cities() {
		List<City> countries = cscService.listCities();
		JsonArray array = new JsonArray();
		for (City city : countries) {
			array.add(toJson(city));
		}
		return array.toString();
	}
	
	@RequestMapping(value = "/rest/cities/{stateId}", method = RequestMethod.GET)
	public String cities(@PathVariable Long stateId) {
		List<City> cities = cscService.listCitiesByState(stateId);
		JsonArray array = new JsonArray();
		for (City city : cities) {
			array.add(toJson(city));
		}
		return array.toString();
	}

	private JsonElement toJson(City city) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("cityId", city.getCityId());
		jsonObject.addProperty("cityName", city.getCityName());
		jsonObject.addProperty("stateId", city.getState().getStateId());
		return jsonObject;
	}
	
	
}
