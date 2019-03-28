package com.lnson.temp.aspect.config;

/**
 * 切面配置
 */
public final class PointcutOptions {

    public static final String POINTCUT_SERVICE = "execution(* com.lnson.temp.lib.service..*.*(..))";

    public static final String POINTCUT_CONTROLLER = "execution(* com.lnson.temp.mvc.controller..*.*(..))";

    public static final String POINTCUT_WEBAPI = "execution(* com.lnson.temp.mvc.webapi..*.*(..))";

}
