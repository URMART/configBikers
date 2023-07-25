package com.mongo.mechanic.mongo.infraestructura.ouput.jpa.adapter;

import com.mongo.mechanic.mongo.domain.model.Mechanic;
import com.mongo.mechanic.mongo.domain.spi.IMechanicPortPersistens;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.mapper.IMechanicEntityMapper;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.repository.IMechanicEntityJpa;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class MechanicAdapater implements IMechanicPortPersistens {

    private final IMechanicEntityMapper mechanicEntityMapper;
    private final IMechanicEntityJpa mechanicEntityJpa;
    @Override
    public List<Mechanic> findAllMechanics() {
        return mechanicEntityMapper.toMechanicsModelList(mechanicEntityJpa.findAll());
    }

    @Override
    public Mechanic findByName(String name) {
        return mechanicEntityMapper.toMechanic(mechanicEntityJpa.findByNameMechanical(name));
    }

    @Override
    public void createMechanic(Mechanic mechanic) {
        mechanicEntityJpa.save(mechanicEntityMapper.toMechanicEntity(mechanic));
    }
}
