package com.bikers.app.infraestructure.output.jpa.repository;

import com.bikers.app.infraestructure.output.jpa.entity.MotorcycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMotorcycleRespository extends JpaRepository<MotorcycleEntity,Long> {
}
