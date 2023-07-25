package com.bikers.app.domain.spi;

import com.bikers.app.domain.model.Bikers;

import java.util.List;
import java.util.Optional;

public interface IBikersPersistencePort {
    public List<Bikers> findAllBikers();

    public Optional<Bikers> findById(Long id);

    public void saveBiker(Bikers bikers);

    public void deleteBiker(Long id);
}
