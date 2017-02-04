package org.phstudy.sample.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "vehicaltype_has_manufacture")
@AssociationOverrides({
		@AssociationOverride(name = "pk.manufacture",
			joinColumns = @JoinColumn(name = "manufacture_id")),
		@AssociationOverride(name = "pk.vehicaltype",
			joinColumns = @JoinColumn(name = "vehicaltype_id")) })
public class VechicleTypeManufacturer implements java.io.Serializable {

	private VechicleTypeManufacturerID pk = new VechicleTypeManufacturerID();
	

	public VechicleTypeManufacturer() {
	}

	@EmbeddedId
	public VechicleTypeManufacturerID getPk() {
		return pk;
	}

	public void setPk(VechicleTypeManufacturerID pk) {
		this.pk = pk;
	}

	@Transient
	public VechicleType getVechicleType() {
		return getPk().getVechicleType();
	}

	public void setStock(VechicleType stock) {
		getPk().setVechicleType(stock);
	}

	@Transient
	public ManufacturerType getManufacturerType() {
		return getPk().getManufacturerType();
	}

	public void setManufacturerType(ManufacturerType category) {
		getPk().setManufacturerType(category);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		VechicleTypeManufacturer that = (VechicleTypeManufacturer) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
