package com.bikers.app.infraestructure.output.jpa.adapter;

import com.bikers.app.domain.model.MotorcycleBiker;
import com.bikers.app.domain.spi.IMotorcycleBikersPersistencePort;
import com.bikers.app.infraestructure.output.jpa.mapper.IMotorcycleBikersEntityMapper;
import com.bikers.app.infraestructure.output.jpa.repository.IMotorcycleBikersRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MotorcyclebikersAdapter implements IMotorcycleBikersPersistencePort {

    private final IMotorcycleBikersRepository motorcycleBikersRepository;
    private final IMotorcycleBikersEntityMapper motorcycleBikersEntityMapper;

    @Override
    public List<MotorcycleBiker> findAllMotorcycleBikers() {
        return motorcycleBikersEntityMapper.toMotorcycleBikerModelList(motorcycleBikersRepository.findAll());
    }

    @Override
    public void saveMotorcycleBikers(MotorcycleBiker motorcycleBiker) {
        motorcycleBikersRepository.save(motorcycleBikersEntityMapper.toMotorcycleBikersEntity(motorcycleBiker));
    }
}
