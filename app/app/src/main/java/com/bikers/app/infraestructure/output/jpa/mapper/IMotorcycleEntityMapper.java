package com.bikers.app.infraestructure.output.jpa.mapper;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.model.Motorcycle;
import com.bikers.app.infraestructure.output.jpa.entity.BikersEntity;
import com.bikers.app.infraestructure.output.jpa.entity.MotorcycleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IMotorcycleEntityMapper {
    public Motorcycle toMotorcycleModel(MotorcycleEntity motorcycleEntity);
    public MotorcycleEntity toMotorcycleEntity(Motorcycle motorcycle);
    List<Motorcycle> toMotorcycleModelList(List<MotorcycleEntity> motorcycleEntityList);
}
