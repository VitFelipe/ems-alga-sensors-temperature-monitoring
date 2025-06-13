package com.algaworks.algasensors.temperature.monitoring.api.controller;

import com.algaworks.algasensors.temperature.monitoring.api.model.assembler.AlertAssembler;
import com.algaworks.algasensors.temperature.monitoring.api.model.input.SensorAlertInput;
import com.algaworks.algasensors.temperature.monitoring.api.model.output.AlertOutput;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorAlert;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorId;
import com.algaworks.algasensors.temperature.monitoring.domain.model.repository.SensorAlertRepository;
import com.algaworks.algasensors.temperature.monitoring.domain.service.UpdateSensorAlertService;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("sensors/{sensorId}/alerts")
@RequiredArgsConstructor
public class SensorAlertController {

    private final SensorAlertRepository sensorAlertRepository;
    private final UpdateSensorAlertService updateSensorAlertService;
    private final AlertAssembler alertAssembler;


    @GetMapping
    public AlertOutput search(@PathVariable String sensorId) {
        Optional<SensorAlert> sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId));
        if(sensorAlert.isEmpty()) {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return alertAssembler.toModel(sensorAlert.get());
    }


    @PutMapping
    public AlertOutput putUpdate(@PathVariable TSID sensorId, SensorAlertInput sensorAlertInput) {
        SensorAlert sensorAlert = updateSensorAlertService.update(sensorId,sensorAlertInput);
        return alertAssembler.toModel(sensorAlert);
    }


    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable TSID sensorId) {
        sensorAlertRepository.delete(findByIdAndValid(sensorId));
        return ResponseEntity.noContent().build();
    }


    public SensorAlert findByIdAndValid(TSID sensorId) {
        Optional<SensorAlert> sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId));
        if(sensorAlert.isEmpty()) {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return sensorAlert.get();
    }




}
