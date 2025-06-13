package com.algaworks.algasensors.temperature.monitoring.domain.model;

import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorAlert {
    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private SensorId id;

    private Double minTemperature;

    private Double maxTemperature;



}
