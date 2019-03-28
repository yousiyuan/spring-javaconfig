package com.lnson.temp.mvc.interceptor;

import com.lnson.temp.proj.components.PermissionHandler;
import com.lnson.temp.util.commons.CustomHttpServletRequestWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring拦截器
 * HandlerInterceptorAdapter需要继承，HandlerInterceptor需要实现
 * 可以作为日志记录和登录校验来使用
 * 建议使用HandlerInterceptorAdapter，因为可以按需进行方法的覆盖
 */
@Component("authorizeInterceptor")
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LogManager.getLogger(AuthorizeInterceptor.class);

    /**
     * 权限检查服务
     */
    @Autowired
    private PermissionHandler permissionHandler;

    /**
     * 最终拦截
     * 拦截于视图解析器解析页面完成之后（此时，jsp页面已经生成出来了）。
     * 作用：可以做一些jsp页面上运行时的监控（项目运行期监控）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.debug("最终拦截");
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 后置拦截
     * 拦截于Controller执行完成后，视图解析器执行之前，可以对modelAndView进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.debug("后置拦截");
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 前置拦截
     * 拦截于请求进入Controller之前，需要boolean类型的返回值进行判断，如果返回true将继续执行Controller，如果返回false，则不执行Controller。
     * 场景：一般用于登录校验。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("前置拦截");
        return true;
/*
        boolean hasPermission = false;

        Class<?> aClass = handler.getClass();
        if (aClass.isAnnotationPresent(Permission.class)) {
            Permission annotation = aClass.getAnnotation(Permission.class);
            hasPermission = permissionHandler.doProcess(annotation, request, response);
        }
        if (!hasPermission)
            response.sendRedirect(request.getContextPath() + "/doc/api");

        return hasPermission;
*/
/*
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        if ("lnson".equals(userId))
            return true;
        return false;
*/
    }

}
