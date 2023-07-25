package com.mongo.brand.mongo.infraestructura.ouput.jpa.repository;

import com.mongo.brand.mongo.infraestructura.ouput.jpa.entity.BrandEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IBrandEntityJpa extends MongoRepository<BrandEntity,String> {

    @Query(" { nameBrand :  { $eq : ?0 } }")
    public BrandEntity findByNameBrand(String name);
}
