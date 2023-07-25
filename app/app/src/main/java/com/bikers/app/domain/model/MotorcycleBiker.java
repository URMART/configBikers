package com.bikers.app.domain.model;

public class MotorcycleBiker {

    private Long id;
    private Bikers idBikers;
    private Motorcycle idMortorcycle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bikers getIdBikers() {
        return idBikers;
    }

    public void setIdBikers(Bikers idBikers) {
        this.idBikers = idBikers;
    }

    public Motorcycle getIdMortorcycle() {
        return idMortorcycle;
    }

    public void setIdMortorcycle(Motorcycle idMortorcycle) {
        this.idMortorcycle = idMortorcycle;
    }

    public MotorcycleBiker(Long id, Bikers idBikers, Motorcycle idMortorcycle) {
        this.id = id;
        this.idBikers = idBikers;
        this.idMortorcycle = idMortorcycle;
    }

    public MotorcycleBiker() {
    }
}
