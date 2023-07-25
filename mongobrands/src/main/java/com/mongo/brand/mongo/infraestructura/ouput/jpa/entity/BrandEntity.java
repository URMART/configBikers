package com.mongo.brand.mongo.infraestructura.ouput.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Brand")
public class BrandEntity {
    @Id
    private String id;
    private String nameBrand;
    private String originCountry;
}
