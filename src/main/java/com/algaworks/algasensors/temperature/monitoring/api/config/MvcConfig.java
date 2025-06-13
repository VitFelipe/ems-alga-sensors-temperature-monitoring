package com.algaworks.algasensors.temperature.monitoring.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
     registry.addConverter(new LongToTsIdConverter());
     registry.addConverter(new StringToTsIdConverter());
    }
}
