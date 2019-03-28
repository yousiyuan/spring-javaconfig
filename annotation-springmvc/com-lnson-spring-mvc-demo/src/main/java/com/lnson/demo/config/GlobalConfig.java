package com.lnson.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = {"com.lnson.demo"}, excludeFilters = @ComponentScan.Filter(classes = Controller.class))
public class GlobalConfig {
}
