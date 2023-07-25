package com.mongo.mechanic.mongo.infraestructura.ouput.jpa.mapper;

import com.mongo.mechanic.mongo.domain.model.Mechanic;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.entity.MechanicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IMechanicEntityMapper {

    MechanicEntity toMechanicEntity(Mechanic mechanic);
    Mechanic toMechanic(MechanicEntity mechanicEntity);
    List<Mechanic> toMechanicsModelList(List<MechanicEntity> mechanicEntity);
}
