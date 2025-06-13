package com.algaworks.algasensors.temperature.monitoring.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
public class SensorId implements Serializable {

    private TSID value;


    public SensorId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public SensorId(String value) {
        Objects.requireNonNull(value,"value must not be null");
        this.value = TSID.from(value);
    }

    public SensorId(Long value) {
        Objects.requireNonNull(value,"value must not be null");
        this.value = TSID.from(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
