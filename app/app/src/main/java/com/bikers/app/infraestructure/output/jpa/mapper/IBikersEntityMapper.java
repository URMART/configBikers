package com.bikers.app.infraestructure.output.jpa.mapper;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.infraestructure.output.jpa.entity.BikersEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IBikersEntityMapper {

    public Bikers toBikersModel(BikersEntity bikersEntity);
    public BikersEntity toBikersEntity(Bikers bikers);
    List<Bikers> toBikersModelList(List<BikersEntity>bikersEntityList);
}
