package com.lnson.demo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Orders {
    private Short orderid;

    private String customerid;

    private Short employeeid;

    private String orderdate;

    private String requireddate;

    private String shippeddate;

    private Short shipvia;

    private Short freight;

    private String shipname;

    private String shipaddress;

    private String shipcity;

    private String shipregion;

    private String shippostalcode;

    private String shipcountry;

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    public Short getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Short employeeid) {
        this.employeeid = employeeid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate == null ? null : orderdate.trim();
    }

    public String getRequireddate() {
        return requireddate;
    }

    public void setRequireddate(String requireddate) {
        this.requireddate = requireddate == null ? null : requireddate.trim();
    }

    public String getShippeddate() {
        return shippeddate;
    }

    public void setShippeddate(String shippeddate) {
        this.shippeddate = shippeddate == null ? null : shippeddate.trim();
    }

    public Short getShipvia() {
        return shipvia;
    }

    public void setShipvia(Short shipvia) {
        this.shipvia = shipvia;
    }

    public Short getFreight() {
        return freight;
    }

    public void setFreight(Short freight) {
        this.freight = freight;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress == null ? null : shipaddress.trim();
    }

    public String getShipcity() {
        return shipcity;
    }

    public void setShipcity(String shipcity) {
        this.shipcity = shipcity == null ? null : shipcity.trim();
    }

    public String getShipregion() {
        return shipregion;
    }

    public void setShipregion(String shipregion) {
        this.shipregion = shipregion == null ? null : shipregion.trim();
    }

    public String getShippostalcode() {
        return shippostalcode;
    }

    public void setShippostalcode(String shippostalcode) {
        this.shippostalcode = shippostalcode == null ? null : shippostalcode.trim();
    }

    public String getShipcountry() {
        return shipcountry;
    }

    public void setShipcountry(String shipcountry) {
        this.shipcountry = shipcountry == null ? null : shipcountry.trim();
    }

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
	}
}