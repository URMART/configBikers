package com.bikers.app.domain.usecase;

import com.bikers.app.domain.api.IBikersServicePort;
import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.spi.IBikersPersistencePort;

import java.util.List;
import java.util.Optional;

public class BikerUseCase implements IBikersServicePort {

    private final IBikersPersistencePort bikersPersistencePort;

    public BikerUseCase(IBikersPersistencePort bikersPersistencePort) {
        this.bikersPersistencePort = bikersPersistencePort;
    }

    @Override
    public List<Bikers> findAllBikers() {
        return bikersPersistencePort.findAllBikers();
    }

    @Override
    public Optional<Bikers> findById(Long id) {
        return Optional.of(bikersPersistencePort.findById(id).orElseThrow());
    }

    @Override
    public void saveBiker(Bikers bikers) {
       bikersPersistencePort.saveBiker(bikers);
    }

    @Override
    public void deleteBiker(Long id) {
        bikersPersistencePort.deleteBiker(id);
    }
}
