package com.algaworks.algasensors.temperature.monitoring.domain.service;

import com.algaworks.algasensors.temperature.monitoring.api.model.assembler.AlertAssembler;
import com.algaworks.algasensors.temperature.monitoring.api.model.input.SensorAlertInput;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorAlert;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorId;
import com.algaworks.algasensors.temperature.monitoring.domain.model.repository.SensorAlertRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateSensorAlertService {

    private final SensorAlertRepository sensorAlertRepository;
    private final AlertAssembler assembler;

    public SensorAlert update(TSID sensorId, SensorAlertInput sensorAlert) {
        SensorAlert sensorAlertToUpdate = sensorAlertRepository.findById(new SensorId(sensorId)).orElseThrow(() -> new RuntimeException("Sensor not found."));
        sensorAlertToUpdate.setMinTemperature(sensorAlert.getMinTemperature());
        sensorAlertToUpdate.setMaxTemperature(sensorAlert.getMaxTemperature());
        return sensorAlertRepository.save(sensorAlertToUpdate);
    }

}
