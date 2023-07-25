package com.mongo.mechanic.mongo.application.mapper;

import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;
import com.mongo.mechanic.mongo.domain.model.Mechanic;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.entity.MechanicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMechanicResponseMapper {
    Mechanic toMechanic(IMechanicResponseMapper mechanicResponseMapper);
    MechanicResponseDto toMechanicResposeDto(Mechanic mechanic);
    List<MechanicResponseDto> toMechanicsDtoList(List<Mechanic> mechanic);

}
