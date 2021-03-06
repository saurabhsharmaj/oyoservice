package com.websystique.springmvc.model;
// Generated Jan 28, 2017 3:06:49 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Servicetype generated by hbm2java
 */
@Entity
@Table(name = "servicetype")
public class ServiceType implements java.io.Serializable {

	private Integer id;
	private String serviceType;
	private String description;
	private Set<ServiceCenter> servicecenters = new HashSet<ServiceCenter>(0);

	public ServiceType() {
	}

	public ServiceType(int id) {
		this.id = id;
	}

	public ServiceType(int id, String serviceType, String description, Set<ServiceCenter> servicecenters) {
		this.id = id;
		this.serviceType = serviceType;
		this.description = description;
		this.servicecenters = servicecenters;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "serviceType", length = 45)
	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
