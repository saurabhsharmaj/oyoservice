package com.websystique.springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.CountryStateCityFilterDAO;
import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Country;
import com.websystique.springmvc.model.State;
import com.websystique.springmvc.service.CountryStateCityFilterService;

@Service
@Transactional
public class CountryStateCityFilterServiceImpl implements CountryStateCityFilterService {

	private static final Logger logger = LoggerFactory.getLogger(CountryStateCityFilterServiceImpl.class);

	@Autowired
	CountryStateCityFilterDAO countryStateCityFilterDAO;

	@Override
	public List<Country> listCountries() {
		return countryStateCityFilterDAO.listCountries();
	}

	@Override
	public List<State> listStates() {
		return countryStateCityFilterDAO.listStates();
	}

	@Override
	public List<State> listStateByCountry(Long countryId) {
		return countryStateCityFilterDAO.listStateByCountry(countryId);
	}

	@Override
	public List<City> listCities() {
		return countryStateCityFilterDAO.listCities();
	}

	@Override
	public List<City> listCitiesByState(Long stateId) {
		return countryStateCityFilterDAO.listCitiesByState(stateId);
	}

}
