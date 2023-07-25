package com.mongo.brand.mongo.application.hadler;

import com.mongo.brand.mongo.application.dto.BrandRequestDto;
import com.mongo.brand.mongo.application.dto.BrandResponseDto;


import java.util.List;


public interface IBrandHandler {

   public List<BrandResponseDto> findAllBrand();
   public BrandResponseDto findByName(String name);
   public  void createBrand(BrandRequestDto mechanic);
}
