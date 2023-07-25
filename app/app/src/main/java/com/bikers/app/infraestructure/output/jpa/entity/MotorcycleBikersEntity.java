package com.bikers.app.infraestructure.output.jpa.entity;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.model.Motorcycle;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "motorcycle_bikers")
@Data
public class MotorcycleBikersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private BikersEntity idBikers;
    @ManyToOne
    private MotorcycleEntity idMortorcycle;
}
