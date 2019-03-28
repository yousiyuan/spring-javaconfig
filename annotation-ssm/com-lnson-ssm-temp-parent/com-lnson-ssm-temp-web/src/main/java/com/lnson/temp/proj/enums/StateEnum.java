package com.lnson.temp.proj.enums;

public enum StateEnum {
    /**
     * SUCCESS - 200, FAIL - 500
     */
    SUCCESS(200), FAIL(500);

    private StateEnum(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return this.value;
    }
}
