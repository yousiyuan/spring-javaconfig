package com.lnson.temp.proj.annotations;

import com.lnson.temp.proj.enums.PermissionEnum;
import com.lnson.temp.proj.enums.RelationEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {

    //权限检查项
    PermissionEnum[] permissionTypes() default {};

    //权限检查项之间的关系
    RelationEnum relation() default RelationEnum.OR;
}
