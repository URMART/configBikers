package com.mongo.brand.mongo.domain.api;



import com.mongo.brand.mongo.domain.model.Brand;

import java.util.List;


public interface IBrandPortService {
    public List<Brand> findAllBrand();
    public Brand findByName(String name);
    public  void createBrand(Brand mechanic);
}
