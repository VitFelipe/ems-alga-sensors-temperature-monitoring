package com.algaworks.algasensors.temperature.monitoring.api.config;

import io.hypersistence.tsid.TSID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LongToTsIdConverter implements Converter<Long, TSID> {
    @Override
    public TSID convert(Long source) {

        if(source == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return TSID.from(source);
    }
}
