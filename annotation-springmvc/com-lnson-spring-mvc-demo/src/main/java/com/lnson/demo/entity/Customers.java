package com.lnson.demo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Customers {
	private String customerid;

	private String companyname;

	private String contactname;

	private String contacttitle;

	private String address;

	private String city;

	private String region;

	private String postalcode;

	private String country;

	private String phone;

	private String fax;

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid == null ? null : customerid.trim();
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname == null ? null : companyname.trim();
	}

	public String getContactname() {
		return contactname;
	}

	public void setContactname(String contactname) {
		this.contactname = contactname == null ? null : contactname.trim();
	}

	public String getContacttitle() {
		return contacttitle;
	}

	public void setContacttitle(String contacttitle) {
		this.contacttitle = contacttitle == null ? null : contacttitle.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region == null ? null : region.trim();
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode == null ? null : postalcode.trim();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
	}
}