package com.lnson.demo.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class OrderDetails {
    private Short orderid;

    private Short productid;

    private Short unitprice;

    private Short quantity;

    public Short getOrderid() {
        return orderid;
    }

    public void setOrderid(Short orderid) {
        this.orderid = orderid;
    }

    public Short getProductid() {
        return productid;
    }

    public void setProductid(Short productid) {
        this.productid = productid;
    }

    public Short getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Short unitprice) {
        this.unitprice = unitprice;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
	}
}