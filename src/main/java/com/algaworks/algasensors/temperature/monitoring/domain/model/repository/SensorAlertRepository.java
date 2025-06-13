package com.algaworks.algasensors.temperature.monitoring.domain.model.repository;

import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorAlert;
import com.algaworks.algasensors.temperature.monitoring.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SensorAlertRepository extends JpaRepository<SensorAlert, SensorId> {




}
