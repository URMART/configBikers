package com.mongo.mechanic.mongo.domain.spi;

import com.mongo.mechanic.mongo.domain.model.Mechanic;

import java.util.List;


public interface IMechanicPortPersistens {
    public List<Mechanic> findAllMechanics();
    public Mechanic findByName(String name);

    public  void createMechanic(Mechanic mechanic);

}
