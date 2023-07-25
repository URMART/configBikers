package com.bikers.app.domain.spi;

import com.bikers.app.domain.model.Motorcycle;

import java.util.List;

public interface IMotorcyclePersistencePort {
    public List<Motorcycle> getAllMotorcycles();
    public Motorcycle getMotorcycleById(Long id);
    public void saveMotorcycle(Motorcycle motorcycle);
}
