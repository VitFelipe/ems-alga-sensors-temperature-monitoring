package com.algaworks.algasensors.temperature.monitoring.api.config;

import io.hypersistence.tsid.TSID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class StringToTsIdConverter implements Converter<String, TSID> {
    @Override
    public TSID convert(String source) {

        if(source == null || source.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

       try{
         long sourceLong =   Long.parseLong(source);
         return TSID.from(sourceLong);
       }catch(NumberFormatException ignored){
           return TSID.from(source);
       }


    }
}
