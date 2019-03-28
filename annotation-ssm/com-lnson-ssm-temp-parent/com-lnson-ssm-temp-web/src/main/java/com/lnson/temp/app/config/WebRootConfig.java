package com.lnson.temp.app.config;

import com.lnson.temp.aspect.config.AspectConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"com.lnson.temp"},
        excludeFilters = @ComponentScan.Filter(classes = Controller.class))
@Import(value = {MybatisConfig.class, AspectConfig.class})
public class WebRootConfig {

}
