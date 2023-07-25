package com.bikers.app.infraestructure.output.jpa.repository;

import com.bikers.app.infraestructure.output.jpa.entity.MotorcycleBikersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMotorcycleBikersRepository extends JpaRepository<MotorcycleBikersEntity,Long> {
}
