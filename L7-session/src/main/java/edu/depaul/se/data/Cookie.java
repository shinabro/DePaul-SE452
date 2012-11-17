package edu.depaul.se.data;

public class Cookie {
	private String manufacturer;
	private String brandName;
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "Cookie [manufacturer=" + manufacturer + ", brandName="
				+ brandName + "]";
	}
	public Cookie(String manufacturer, String brandName) {
		super();
		this.manufacturer = manufacturer;
		this.brandName = brandName;
	}
	
	public Cookie() {
		super();
	}
}
