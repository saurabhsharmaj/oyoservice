package com.websystique.springmvc.model;
// Generated Jan 28, 2017 3:06:49 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Servicecenter generated by hbm2java
 */
@Document(indexName="servicecenter")
@Entity
@Table(name = "servicecenter")
public class ServiceCenter {

	private Integer id;
	private String name;
	private String houseno;
	private String street;
	private String place;
	private String city;
	private String state;
	private String pincode;
	private String emailid;
	private String mobileno;
	private Set<ServiceType> servicetypes = new HashSet<ServiceType>(0);
	private Servercenterdetails servercenterdetails;
	private Set<VechicleType> vehicaltypes = new HashSet<VechicleType>(0);
	private Set<BookService> bookservices = new HashSet<BookService>(0);
	private Set<Deal> deals = new HashSet<Deal>(0);

	public ServiceCenter() {
	}

	public ServiceCenter(int id) {
		this.id = id;
	}

	public ServiceCenter(int id, String name, String houseno, String street, String place, String city, String state,
			String pincode, String emailid, String mobileno, Set<ServiceType> servicetypes,
			Servercenterdetails servercenterdetails, Set<VechicleType> vehicaltypes, Set<BookService> bookservices,
			Set<Deal> deals) {
		this.id = id;
		this.name = name;
		this.houseno = houseno;
		this.street = street;
		this.place = place;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.servicetypes = servicetypes;
		this.servercenterdetails = servercenterdetails;
		this.vehicaltypes = vehicaltypes;
		this.bookservices = bookservices;
		this.deals = deals;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "houseno", length = 45)
	public String getHouseno() {
		return this.houseno;
	}

	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}

	@Column(name = "street", length = 45)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "place", length = 45)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 45)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "pincode", length = 45)
	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "emailid", length = 45)
	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "mobileno", length = 45)
	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

}
