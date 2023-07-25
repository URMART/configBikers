package com.bikers.app.infraestructure.output.jpa.mapper;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.model.MotorcycleBiker;
import com.bikers.app.infraestructure.output.jpa.entity.MotorcycleBikersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IMotorcycleBikersEntityMapper {
    public MotorcycleBiker toMotorcycleBikerModel(MotorcycleBikersEntity motorcycleBikersEntity);
    public MotorcycleBikersEntity toMotorcycleBikersEntity(MotorcycleBiker motorcycleBiker);
    List<MotorcycleBiker> toMotorcycleBikerModelList(List<MotorcycleBikersEntity> motorcycleBikersEntityList);

}
