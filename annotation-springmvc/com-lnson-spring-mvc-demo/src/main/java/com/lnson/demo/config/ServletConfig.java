package com.lnson.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(value = {"com.lnson.demo.controller", "com.lnson.demo.webapi"},
        includeFilters = @ComponentScan.Filter(classes = Controller.class),
        useDefaultFilters = false)
public class ServletConfig extends WebMvcConfigurerAdapter {

    /**
     * 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
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
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/JScript/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/Image/");
        super.addResourceHandlers(registry);
    }

}
