package com.algaworks.algasensors.temperature.monitoring.api.model.assembler;

import com.algaworks.algasensors.temperature.monitoring.api.model.input.SensorAlertInput;
import com.algaworks.algasensors.temperature.monitoring.api.model.output.AlertOutput;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorAlert;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorId;
import io.hypersistence.tsid.TSID;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AlertAssembler {


    public AlertOutput toModel(SensorAlert sensorAlert) {
        return AlertOutput.builder()
                .sensorId(sensorAlert.getId().getValue().toString())
                .minTemperature(sensorAlert.getMinTemperature())
                .maxTemperature(sensorAlert.getMaxTemperature())
                .build();
    }

    public SensorAlert toEntity(SensorAlertInput input, TSID id) {
        return SensorAlert.builder()
                .id(new SensorId(id))
                .minTemperature(input.getMinTemperature())
                .maxTemperature(input.getMaxTemperature())
                .build();
    }



}
