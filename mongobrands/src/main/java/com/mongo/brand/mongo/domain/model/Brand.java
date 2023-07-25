package com.mongo.brand.mongo.domain.model;

public class Brand {

    private String id;
    private String nameBrand;

    private String originCountry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public Brand(String id, String nameBrand, String originCountry) {
        this.id = id;
        this.nameBrand = nameBrand;
        this.originCountry = originCountry;
    }

    public Brand() {
    }
}
