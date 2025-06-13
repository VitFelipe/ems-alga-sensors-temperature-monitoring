package com.algaworks.algasensors.temperature.monitoring.api.model.output;

import io.hypersistence.tsid.TSID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorMonitoringOutput {
    private TSID id;
    private OffsetDateTime updatedAt;
    private Double lastValue;
    private Boolean enabled;
}
