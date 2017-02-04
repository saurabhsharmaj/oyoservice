package org.phstudy.sample.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicaltype_has_manufacture")
@AssociationOverrides({
		@AssociationOverride(name = "pk.manufacture",
			joinColumns = @JoinColumn(name = "manufacture_id")),
		@AssociationOverride(name = "pk.vehicaltype",
			joinColumns = @JoinColumn(name = "vehicaltype_id")) })
public class VechicleTypeManufacturer implements java.io.Serializable {

	@Id
    @AttributeOverrides({
    @AttributeOverride(name = "vechicleType",
    column = @Column(name="id")),
    @AttributeOverride(name = "manufacturerType",
    column = @Column(name="id"))
    })
	private VechicleType vechicleType;
	private ManufacturerType manufacturerType;
	
	@ManyToOne
	public VechicleType getVechicleType() {
		return vechicleType;
	}
	public void setVechicleType(VechicleType vechicleType) {
		this.vechicleType = vechicleType;
	}
	
	@ManyToOne
	public ManufacturerType getManufacturerType() {
		return manufacturerType;
	}
	public void setManufacturerType(ManufacturerType manufacturerType) {
		this.manufacturerType = manufacturerType;
	}
	
}
