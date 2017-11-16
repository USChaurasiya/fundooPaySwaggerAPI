package com.bridgelabz.fundooPay.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity

@NamedQuery(query = "select sp from ServiceProvider sp", name = "query_find_all_sp")
public class ServiceProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Long id;
	@ApiModelProperty(notes = "Provided user name", required = true)
	private String spName;
	@ApiModelProperty(notes = "Provided Shop Name", required = true)
	private String spShopName;
	@ApiModelProperty(notes = "Select Service type", required = true)
	private String ServiceType;
	@ApiModelProperty(notes = "Provided Mobile Number", required = true)
	private String spMobile;
	@ApiModelProperty(notes = "Provided Email", required = true)
	private String spMail;
	@ApiModelProperty(notes = "Set Locations", required = true)
	@OneToOne(cascade = {CascadeType.ALL})
	private Location location;

	
	
	public String getSpMail() {
		return spMail;
	}

	public void setSpMail(String spMail) {
		this.spMail = spMail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ServiceProvider() {
		// TODO Auto-generated constructor stub
	}

	

	public Long getId() {
		return id;
	}

	/*public void setId(Long id) {
		this.id = id;
	}
*/
	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpShopName() {
		return spShopName;
	}

	public void setSpShopName(String spShopName) {
		this.spShopName = spShopName;
	}

	public String getServiceType() {
		return ServiceType;
	}

	public void setServiceType(String serviceType) {
		ServiceType = serviceType;
	}

	public String getSpMobile() {
		return spMobile;
	}

	public void setSpMobile(String spMobile) {
		this.spMobile = spMobile;
	}

}
