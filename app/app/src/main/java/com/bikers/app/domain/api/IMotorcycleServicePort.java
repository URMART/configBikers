package com.bikers.app.domain.api;

import com.bikers.app.domain.model.Motorcycle;

import java.util.List;

public interface IMotorcycleServicePort {
    public List<Motorcycle> getAllMotorcycles();
    public Motorcycle getMotorcycleById(Long id);
    public void saveMotorcycle(Motorcycle motorcycle);
}
