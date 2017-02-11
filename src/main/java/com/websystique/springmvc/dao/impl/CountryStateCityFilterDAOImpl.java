package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.CountryStateCityFilterDAO;
import com.websystique.springmvc.model.City;
import com.websystique.springmvc.model.Country;
import com.websystique.springmvc.model.State;

@Repository
public class CountryStateCityFilterDAOImpl implements CountryStateCityFilterDAO {

	private static final Logger logger = LoggerFactory.getLogger(CountryStateCityFilterDAOImpl.class);

	@Autowired
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Country> listCountries() {
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}

	@Override
	public List<State> listStates() {
		return sessionFactory.getCurrentSession().createQuery("from State").list();
	}

	@Override
	public List<State> listStateByCountry(Long countryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(State.class);
		c.add(Restrictions.eq("country.countryId", countryId));
		return c.list();
	}

	@Override
	public List<City> listCities() {
		return sessionFactory.getCurrentSession().createQuery("from City").list();
	}

	@Override
	public List<City> listCitiesByState(Long stateId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(City.class);
		c.add(Restrictions.eq("state.stateId", stateId));
		return c.list();
	}

}
