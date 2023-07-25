package com.mongo.mechanic.mongo.application.mapper;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.domain.model.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMechanicRequestMapper {
    Mechanic toMechanic(MechanicRequestDto mechanicRequestDto);

}
