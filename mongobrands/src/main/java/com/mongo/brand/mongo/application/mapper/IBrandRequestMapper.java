package com.mongo.brand.mongo.application.mapper;

import com.mongo.brand.mongo.application.dto.BrandRequestDto;
import com.mongo.brand.mongo.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBrandRequestMapper {
    Brand toBrand(BrandRequestDto brandRequestDto);
    BrandRequestDto toBrandRequestDto(Brand  brand );
}
