package com.algaworks.algasensors.temperature.monitoring.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class TemperatureLogId implements Serializable {

    private UUID value;
    public TemperatureLogId(String value) {
        this.value = UUID.fromString(value);
    }


}
