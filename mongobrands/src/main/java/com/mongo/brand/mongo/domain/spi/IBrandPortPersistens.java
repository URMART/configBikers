package com.mongo.brand.mongo.domain.spi;

import com.mongo.brand.mongo.domain.model.Brand;


import java.util.List;


public interface IBrandPortPersistens {
    public List<Brand> findAllBrand();
    public Brand findByName(String name);

    public  void createBrand(Brand mechanic);

}
