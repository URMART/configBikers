package com.bikers.app.domain.model;

public class Motorcycle {
    private Long id;
    private String nameMotorcycle;
    private Boolean State;
    private String idBrand;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMotorcycle() {
        return nameMotorcycle;
    }

    public void setNameMotorcycle(String nameMotorcycle) {
        this.nameMotorcycle = nameMotorcycle;
    }

    public Boolean getState() {
        return State;
    }

    public void setState(Boolean state) {
        State = state;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public Motorcycle(Long id, String nameMotorcycle, Boolean state, String idBrand) {
        this.id = id;
        this.nameMotorcycle = nameMotorcycle;
        State = state;
        this.idBrand = idBrand;
    }

    public Motorcycle() {
    }
}
