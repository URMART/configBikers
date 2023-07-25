package com.mongo.mechanic.mongo.infraestructura.ouput.jpa.repository;

import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.entity.MechanicEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IMechanicEntityJpa extends MongoRepository<MechanicEntity,String> {

    @Query(" { NameMechanical :  { $eq : ?0 } }")
    public MechanicEntity findByNameMechanical(String name);
}
