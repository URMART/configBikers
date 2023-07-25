package com.bikers.app.infraestructure.output.jpa.adapter;

import com.bikers.app.domain.model.Motorcycle;
import com.bikers.app.domain.spi.IMotorcyclePersistencePort;
import com.bikers.app.infraestructure.output.jpa.mapper.IMotorcycleEntityMapper;
import com.bikers.app.infraestructure.output.jpa.repository.IMotorcycleRespository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class MotorcycleAdapter implements IMotorcyclePersistencePort {

    private final IMotorcycleRespository motorcycleRespository;
    private final IMotorcycleEntityMapper motorcycleEntityMapper;



    @Override
    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleEntityMapper.toMotorcycleModelList(motorcycleRespository.findAll());
    }

    @Override
    public Motorcycle getMotorcycleById(Long id) {
        // buscar solucion a esa respuesta que tumba es servicio
        return motorcycleEntityMapper.toMotorcycleModel(motorcycleRespository.findById(id).orElseThrow());
    }

    @Override
    public void saveMotorcycle(Motorcycle motorcycle) {
        motorcycleRespository.save(motorcycleEntityMapper.toMotorcycleEntity(motorcycle));
    }
}
