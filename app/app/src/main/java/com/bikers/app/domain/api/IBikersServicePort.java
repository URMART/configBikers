package com.bikers.app.domain.api;

import com.bikers.app.domain.model.Bikers;

import java.util.List;
import java.util.Optional;

public interface IBikersServicePort {

    public Optional<Bikers> findById(Long id);
    public List<Bikers> findAllBikers();

    public void saveBiker(Bikers bikers);

    public void deleteBiker(Long id);



    }