package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Country;
import com.websystique.springmvc.model.State;

public interface CountryStateCityFilterDAO {
	public List<Country> listCountries();
	public List<State> listStates();
	public List<State> listStateByCountry(Long countryId);
	public List<City> listCities();
	public List<City> listCitiesByState(Long stateId);
}
