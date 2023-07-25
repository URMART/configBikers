package com.bikers.app.application.mapper.motorcycle;

import com.bikers.app.application.dto.motorcycle.response.MotorcycleResponseDto;
import com.bikers.app.domain.model.Motorcycle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMotorcycleResponseMapper {

    MotorcycleResponseDto toMotorcycleResponse(Motorcycle motorcycle);
    List<MotorcycleResponseDto> toMotorcycleResponseList(List<Motorcycle>motorcycleList);

}
