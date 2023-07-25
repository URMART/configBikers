package com.bikers.app.domain.spi;

import com.bikers.app.domain.model.MotorcycleBiker;

import java.util.List;

public interface IMotorcycleBikersPersistencePort {
    public List<MotorcycleBiker> findAllMotorcycleBikers();
    public void  saveMotorcycleBikers(MotorcycleBiker motorcycleBiker);
}
