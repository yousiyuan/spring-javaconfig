package com.lnson.temp.aspect.config;

import com.lnson.temp.aspect.sections.ServiceAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)//启用AspectJ注解的自动代理
@ComponentScan(basePackages = {"com.lnson.temp.lib.dao", "com.lnson.temp.lib.service", "com.lnson.temp.mvc"})
public class AspectConfig {

    @Bean
    public ServiceAdvice serviceAdvice() {
        return new ServiceAdvice();
    }

}
