package com.bikers.app.application.mapper.bikers;

import com.bikers.app.application.dto.bikers.request.BikerRequestDto;
import com.bikers.app.domain.model.Bikers;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikerRequestMapper {
    Bikers toBikers (BikerRequestDto bikerRequestDto);
}
