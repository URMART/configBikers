package com.mongo.brand.mongo.application.dto;

import lombok.Data;

@Data
public class BrandResponseDto {
    private String id;
    private String nameBrand;

    private String originCountry;
}
