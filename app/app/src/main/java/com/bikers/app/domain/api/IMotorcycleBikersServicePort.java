package com.bikers.app.domain.api;

import com.bikers.app.domain.model.MotorcycleBiker;

import java.util.List;

public interface IMotorcycleBikersServicePort {

    public List<MotorcycleBiker> findAllMotorcycleBikers();
    public void  saveMotorcycleBikers(MotorcycleBiker motorcycleBiker);

}
