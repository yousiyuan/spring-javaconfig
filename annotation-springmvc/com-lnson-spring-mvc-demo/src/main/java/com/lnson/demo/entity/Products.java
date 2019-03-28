package com.lnson.demo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Products implements java.io.Serializable {

	private static final long serialVersionUID = 2449143978051315028L;

	private Integer productid;

    private String productname;

    private Short supplierid;

    private Short categoryid;

    private String quantityperunit;

    private Short unitprice;

    private Short unitsinstock;

    private Short unitsonorder;

    private Short reorderlevel;

    private Short discontinued;

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Short getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Short supplierid) {
        this.supplierid = supplierid;
    }

    public Short getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Short categoryid) {
        this.categoryid = categoryid;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit == null ? null : quantityperunit.trim();
    }

    public Short getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Short unitprice) {
        this.unitprice = unitprice;
    }

    public Short getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Short unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Short getUnitsonorder() {
        return unitsonorder;
    }

    public void setUnitsonorder(Short unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    public Short getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(Short reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public Short getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Short discontinued) {
        this.discontinued = discontinued;
    }

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
	}
}