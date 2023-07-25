package com.mongo.brand.mongo.infraestructura.ouput.jpa.adapter;

import com.mongo.brand.mongo.domain.model.Brand;
import com.mongo.brand.mongo.domain.spi.IBrandPortPersistens;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.entity.BrandEntity;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.mapper.IBrandEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrandAdapterMongoTemplate implements IBrandPortPersistens {
    //actualmente se esta usando esta implementacion para este microservicio

    private final IBrandEntityMapper brandEntityMapper;
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Brand> findAllBrand() {
        return brandEntityMapper.toBrandModelList(mongoTemplate.findAll(BrandEntity.class));
    }

    @Override
    public Brand findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nameBrand").is(name));
        BrandEntity brandEntity = mongoTemplate.findOne(query, BrandEntity.class);
        return brandEntityMapper.toBrand( brandEntity);
    }

    @Override
    public void createBrand(Brand mechanic) {
         mongoTemplate.save(brandEntityMapper.toBrandEntity(mechanic));
    }

}
