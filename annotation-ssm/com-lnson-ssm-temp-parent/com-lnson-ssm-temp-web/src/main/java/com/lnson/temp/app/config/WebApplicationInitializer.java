package com.lnson.temp.app.config;

import com.lnson.temp.mvc.filter.TranslateRequestFilter;
import org.apache.logging.log4j.web.Log4jServletContextListener;
import org.apache.logging.log4j.web.Log4jServletFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring IOC环境配置
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    /**
     * Servlet环境配置
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebServletConfig.class};
    }

    /**
     * 拦截请求配置
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 动态注册Filter
     */
    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {

        servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8", true));

        servletContext.setInitParameter("log4jConfigLocation", "classpath*:log4j.properties");
        servletContext.addListener(Log4jServletContextListener.class);
        servletContext.addFilter("log4jServletFilter", Log4jServletFilter.class);

        return super.registerServletFilter(servletContext, filter);
    }

    /**
     * 添加Filter过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        TranslateRequestFilter translateRequestFilter = new TranslateRequestFilter();
        return new Filter[]{translateRequestFilter};
    }

}
