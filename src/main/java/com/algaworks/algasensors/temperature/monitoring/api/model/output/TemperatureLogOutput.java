package com.algaworks.algasensors.temperature.monitoring.api.model.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemperatureLogOutput {

    private UUID id;
    private Double value;
    private OffsetDateTime registeredAt;
    private String  sensorId;
}
