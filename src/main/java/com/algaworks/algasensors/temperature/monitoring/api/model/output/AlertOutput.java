package com.algaworks.algasensors.temperature.monitoring.api.model.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertOutput {
    private String sensorId;
    private Double minTemperature;
    private Double maxTemperature;
}
