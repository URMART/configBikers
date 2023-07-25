package com.bikers.app.infraestructure.output.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "motorcycle")
@Data
public class MotorcycleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty
    private String nameMotorcycle;


    private Boolean state;

    @NotEmpty
    private String idBrand;
}
