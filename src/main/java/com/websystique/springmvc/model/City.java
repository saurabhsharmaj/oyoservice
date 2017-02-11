package com.websystique.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City implements java.io.Serializable {

	Long cityId;
	String cityName;
	State state;
	
	@Id

	@Column(name = "cityId", unique = true, nullable = false)
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	@Column(name = "cityname", length = 45)
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stateId")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
}
