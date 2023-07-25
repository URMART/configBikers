package com.bikers.app.infraestructure.output.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "bikers")
@Data
public class BikersEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String emailAddress;

    @NotEmpty
    private String mechanic;
}
