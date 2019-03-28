package com.lnson.temp.proj.components;

import com.lnson.temp.proj.annotations.Permission;
import com.lnson.temp.proj.enums.PermissionEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限校验
 */
@Component("permissionHandler")
public class PermissionHandler {

    private final static Logger logger = LogManager.getLogger(PermissionHandler.class);

    public boolean doProcess(Permission permission, HttpServletRequest request, HttpServletResponse response) {
        PermissionEnum[] permissionTypes = permission.permissionTypes();
        try {
            String uid = request.getParameter("uid");
            if ("lnson".equals(uid)) {
                logger.info("Authorize Successful");
                return true;
            } else {
                logger.info("Authorize failful");
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
