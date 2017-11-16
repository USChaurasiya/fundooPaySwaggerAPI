package com.bridgelabz.fundooPay.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private long lId;
	@ApiModelProperty(notes = "Provided Location Name", required = false)
	private String lName;
	@ApiModelProperty(notes = "Provided Location Lat", required = true)
	private String latitude;
	@ApiModelProperty(notes = "Provided Location long", required = true)
	private String longitude;

	public Location(long lId, String lName, String latitude, String longitude) {
		super();
		this.lId = lId;
		this.lName = lName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public long getlId() {
		return lId;
	}

	/*
	 * public void setlId(long lId) { this.lId = lId; }
	 */
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}
