package com.mongo.brand.mongo.domain.usecase;

import com.mongo.brand.mongo.common.exeptions.DomainExeptions;
import com.mongo.brand.mongo.domain.api.IBrandPortService;
import com.mongo.brand.mongo.domain.model.Brand;
import com.mongo.brand.mongo.domain.spi.IBrandPortPersistens;

import java.util.List;

public class BrandUseCase implements IBrandPortService {

    private final IBrandPortPersistens brandPortPersistens;

    public BrandUseCase(IBrandPortPersistens brandPortPersistens) {
        this.brandPortPersistens = brandPortPersistens;
    }


    @Override
    public List<Brand> findAllBrand() {
        List<Brand> listBrands = brandPortPersistens.findAllBrand();
        if (listBrands != null) {
            return listBrands;
        }
        throw new DomainExeptions("List of Brands is Empty");
    }

    @Override
    public Brand findByName(String name) {
        return brandPortPersistens.findByName(name);
    }

    @Override
    public void createBrand(Brand brand) {
        brandPortPersistens.createBrand(brand);
    }
}
