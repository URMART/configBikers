package com.bikers.app.domain.usecase;

import com.bikers.app.domain.api.IMotorcycleServicePort;
import com.bikers.app.common.exeptions.DomainExeptions;
import com.bikers.app.domain.model.Motorcycle;
import com.bikers.app.domain.spi.IMotorcyclePersistencePort;

import java.util.List;

public class MotorcycleUseCase implements IMotorcycleServicePort {

    private final IMotorcyclePersistencePort motorcyclePersistencePort;

    public MotorcycleUseCase(IMotorcyclePersistencePort motorcyclePersistencePort) {
        this.motorcyclePersistencePort = motorcyclePersistencePort;
    }

    @Override
    public List<Motorcycle> getAllMotorcycles() {
       return motorcyclePersistencePort.getAllMotorcycles();
    }

    @Override
    public Motorcycle getMotorcycleById(Long id) {
        return  motorcyclePersistencePort.getMotorcycleById(id);
    }

    @Override
    public void saveMotorcycle(Motorcycle motorcycle) {
        try {
            motorcyclePersistencePort.saveMotorcycle(motorcycle);
        } catch (Exception e) {
            throw new  DomainExeptions(e.getMessage());
        }
    }
}
