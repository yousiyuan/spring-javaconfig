package com.lnson.temp.util.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lnson.temp.proj.enums.StateEnum;

import java.io.Serializable;

public class JsonResult implements Serializable {

    private static final Long serialVersionUID = -3644950655568598241L;

    private StateEnum state;

    private Object data;

    private String message;

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonResult() {
    }

    private JsonResult(StateEnum stateEnum, String message, Object data) {
        this.setState(stateEnum);
        this.setMessage(message);
        this.setData(data);
    }

    public static JsonResult build(StateEnum stateEnum, String message) {
        return build(stateEnum, message, null);
    }

    public static JsonResult build(StateEnum stateEnum, String message, Object data) {
        return new JsonResult(stateEnum, message, data);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames);
    }

}
