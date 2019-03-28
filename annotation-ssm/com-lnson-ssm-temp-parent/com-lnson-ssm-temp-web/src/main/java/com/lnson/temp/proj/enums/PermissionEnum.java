package com.lnson.temp.proj.enums;

public enum PermissionEnum {
    /**
     * 100 - 有效，404 - 冻结
     */
    DEVELOPER_VALID(200), DEVELOPER_FREEZE(404);

    private PermissionEnum(Integer value) {
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return this.value;
    }
}
