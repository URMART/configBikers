package com.bikers.app.domain.usecase;

import com.bikers.app.domain.api.IMotorcycleBikersServicePort;
import com.bikers.app.common.exeptions.DomainExeptions;
import com.bikers.app.domain.model.MotorcycleBiker;
import com.bikers.app.domain.spi.IMotorcycleBikersPersistencePort;

import java.util.List;

public class MotorcycleBikerUseCase implements IMotorcycleBikersServicePort {

    private final IMotorcycleBikersPersistencePort motorcycleBikersPersistencePort;

    public MotorcycleBikerUseCase(IMotorcycleBikersPersistencePort motorcycleBikersPersistencePort) {
        this.motorcycleBikersPersistencePort = motorcycleBikersPersistencePort;
    }

    @Override
    public List<MotorcycleBiker> findAllMotorcycleBikers() {
        List<MotorcycleBiker> motorcycleList = motorcycleBikersPersistencePort.findAllMotorcycleBikers();
        if(!motorcycleList.isEmpty()){
            return motorcycleList;
        }
        throw  new DomainExeptions("List of motorcycles is empty");
    }

    @Override
    public void saveMotorcycleBikers(MotorcycleBiker motorcycleBiker) {
        try {
            motorcycleBikersPersistencePort.saveMotorcycleBikers(motorcycleBiker);
        } catch (Exception e) {
            throw new  DomainExeptions("Save failed");
        }
    }
}
