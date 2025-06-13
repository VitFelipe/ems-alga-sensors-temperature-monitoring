package com.algaworks.algasensors.temperature.monitoring.api.config.jackson;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public Module customJacksonModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(TSID.class, new TsIdToStringSerializer());
        return module;
    }


}
