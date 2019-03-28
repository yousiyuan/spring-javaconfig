package com.lnson.temp.app.config;

import com.lnson.temp.mvc.interceptor.AuthorizeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.lnson.temp.mvc.controller", "com.lnson.temp.mvc.webapi"},
        includeFilters = @ComponentScan.Filter(classes = Controller.class),
        useDefaultFilters = false)
public class WebServletConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorizeInterceptor authorizeInterceptor;

    /**
     * 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/VIEWS/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**
     * 配置静态资源
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 处理静态资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations( "/WEB-INF/static/");
    }

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 添加拦截规则
        //excludePathPatterns 排除拦截
        registry.addInterceptor(authorizeInterceptor)
                .addPathPatterns("/webapi/*")
                .excludePathPatterns("/index", "/");
    }

}
