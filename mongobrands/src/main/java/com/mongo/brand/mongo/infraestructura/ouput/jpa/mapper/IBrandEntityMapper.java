package com.mongo.brand.mongo.infraestructura.ouput.jpa.mapper;

import com.mongo.brand.mongo.domain.model.Brand;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IBrandEntityMapper {

    BrandEntity toBrandEntity(Brand brand);
    Brand toBrand(BrandEntity brandEntity);
    List<Brand> toBrandModelList(List<BrandEntity> brandEntityList);
}
