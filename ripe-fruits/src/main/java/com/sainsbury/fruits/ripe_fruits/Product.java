package com.sainsbury.fruits.ripe_fruits;

/**
 * 
 * @author Rabia Shaheen
 *
 */
public class Product {
	
	String title;
	double pricePerUnit = 0.0;
	double pricePerMeasure = 0.0;
	String description;
	
	@Override
	public String toString() {
		
		return "Product [title=" + title + ", pricePerUnit=" + pricePerUnit
				+ ", pricePerMeasure=" + pricePerMeasure + ", description="
				+ description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pricePerMeasure);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pricePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(pricePerMeasure) != Double
				.doubleToLongBits(other.pricePerMeasure))
			return false;
		if (Double.doubleToLongBits(pricePerUnit) != Double
				.doubleToLongBits(other.pricePerUnit))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getPricePerMeasure() {
		return pricePerMeasure;
	}
	public void setPricePerMeasure(double pricePerMeasure) {
		this.pricePerMeasure = pricePerMeasure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
