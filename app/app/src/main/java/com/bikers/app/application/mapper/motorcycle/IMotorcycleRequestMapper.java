package com.bikers.app.application.mapper.motorcycle;

import com.bikers.app.application.dto.motorcycle.request.MotorcycleRequestDto;
import com.bikers.app.domain.model.Motorcycle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMotorcycleRequestMapper {
    Motorcycle toMotorcycle(MotorcycleRequestDto motorcycleRequestDto);
}
