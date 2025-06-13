package com.algaworks.algasensors.temperature.monitoring.api.model.input;

import io.hypersistence.tsid.TSID;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorAlertInput {
    private Double minTemperature;
    private Double maxTemperature;
}
