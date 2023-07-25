package com.bikers.app.infraestructure.output.jpa.repository;
import com.bikers.app.infraestructure.output.jpa.entity.BikersEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBikersRepository extends JpaRepository<BikersEntity,Long> {



}
