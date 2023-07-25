package com.mongo.brand.mongo.application.mapper;

import com.mongo.brand.mongo.application.dto.BrandResponseDto;
import com.mongo.brand.mongo.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBrandResponseMapper {
    Brand toBrand(IBrandResponseMapper brandResponseMapper);
    BrandResponseDto toBrandResposeDto(Brand brand);
    List<BrandResponseDto> toBrandDtoList(List<Brand> brands);

}
