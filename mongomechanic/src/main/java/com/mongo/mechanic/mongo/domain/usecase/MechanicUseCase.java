package com.mongo.mechanic.mongo.domain.usecase;

import com.mongo.mechanic.mongo.common.exeptions.DomainExeptions;
import com.mongo.mechanic.mongo.domain.api.IMechanicPortService;
import com.mongo.mechanic.mongo.domain.model.Mechanic;
import com.mongo.mechanic.mongo.domain.spi.IMechanicPortPersistens;
import org.springframework.http.HttpStatus;

import java.util.List;

public class MechanicUseCase implements IMechanicPortService {

    private final IMechanicPortPersistens mechanicPortPersistens;

    public MechanicUseCase(IMechanicPortPersistens mechanicPortPersistens) {
        this.mechanicPortPersistens = mechanicPortPersistens;
    }

    @Override
    public List<Mechanic> findAllMechanics() {
        List<Mechanic> listMechanics = mechanicPortPersistens.findAllMechanics();
        if (listMechanics != null) {
            return listMechanics;
        }
        throw new DomainExeptions("List of Mechanics is Empty");
    }

    @Override
    public Mechanic findByName(String name) {
        return mechanicPortPersistens.findByName(name);
    }

    @Override
    public void createMechanic(Mechanic mechanic) {
        mechanicPortPersistens.createMechanic(mechanic);
    }
}
