package com.bikers.app.infraestructure.output.jpa.adapter;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.spi.IBikersPersistencePort;
import com.bikers.app.infraestructure.output.jpa.mapper.IBikersEntityMapper;
import com.bikers.app.infraestructure.output.jpa.repository.IBikersRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class BikersAdpater implements IBikersPersistencePort {

    private final IBikersEntityMapper bikersEntityMapper;
    private final IBikersRepository bikersRepository;

    @Override
    public List<Bikers> findAllBikers() {
        return bikersEntityMapper.toBikersModelList(bikersRepository.findAll());
    }

    @Override
    public Optional<Bikers> findById(Long id) {
        return Optional.of(bikersEntityMapper.toBikersModel(bikersRepository.findById(id).orElseThrow()));
    }

    @Override
    public void saveBiker(Bikers bikers) {
        bikersRepository.save(bikersEntityMapper.toBikersEntity(bikers));
    }

    @Override
    public void deleteBiker(Long id) {
        bikersRepository.deleteById(id);
    }

}
