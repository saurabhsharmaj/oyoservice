package org.phstudy.sample.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VechicleTypeManufacturerID  implements Serializable{

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((manufacturerType == null) ? 0 : manufacturerType.hashCode());
		result = prime * result + ((vechicleType == null) ? 0 : vechicleType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VechicleTypeManufacturerID other = (VechicleTypeManufacturerID) obj;
		if (manufacturerType == null) {
			if (other.manufacturerType != null)
				return false;
		} else if (!manufacturerType.equals(other.manufacturerType))
			return false;
		if (vechicleType == null) {
			if (other.vechicleType != null)
				return false;
		} else if (!vechicleType.equals(other.vechicleType))
			return false;
		return true;
	}
	
	
}
