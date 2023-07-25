package com.mongo.brand.mongo.infraestructura.ouput.jpa.adapter;

import com.mongo.brand.mongo.domain.model.Brand;
import com.mongo.brand.mongo.domain.spi.IBrandPortPersistens;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.mapper.IBrandEntityMapper;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.repository.IBrandEntityJpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class BrandAdapaterMongoDataJpa implements IBrandPortPersistens {

    private final IBrandEntityMapper brandEntityMapper;
    private final IBrandEntityJpa brandEntityJpa;
    @Override
    public List<Brand> findAllBrand() {
        return brandEntityMapper.toBrandModelList(brandEntityJpa.findAll());
    }

    @Override
    public Brand findByName(String name) {
        return brandEntityMapper.toBrand(brandEntityJpa.findByNameBrand(name));
    }

    @Override
    public void createBrand(Brand brand) {
        brandEntityJpa.save(brandEntityMapper.toBrandEntity(brand));
    }
}
