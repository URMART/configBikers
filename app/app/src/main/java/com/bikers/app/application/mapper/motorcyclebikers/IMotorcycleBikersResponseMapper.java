package com.bikers.app.application.mapper.motorcyclebikers;

import com.bikers.app.application.dto.motorcyclebikers.response.MotorcycleBikersResponseDto;
import com.bikers.app.domain.model.MotorcycleBiker;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMotorcycleBikersResponseMapper {

    MotorcycleBikersResponseDto toMotorcycleBikersResponseDto(MotorcycleBiker motorcycleBiker);
    List<MotorcycleBikersResponseDto> toMotorcycleBikersResponseDto(List<MotorcycleBiker> motorcycleBiker);

}
