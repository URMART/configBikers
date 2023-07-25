package com.bikers.app.application.mapper.motorcyclebikers;

import com.bikers.app.application.dto.motorcyclebikers.request.MotorcycleBikersRequestDto;
import com.bikers.app.domain.model.MotorcycleBiker;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMotorcycleBikersRequestMapper {
    MotorcycleBiker toMotorcycleBiker(MotorcycleBikersRequestDto motorcycleBikersRequestDto);
}
