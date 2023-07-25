package com.bikers.app.application.mapper.bikers;

import com.bikers.app.application.dto.bikers.response.BikerResponseDto;
import com.bikers.app.domain.model.Bikers;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBikerResponseMapper {

    BikerResponseDto toBikerResponseDto(Bikers bikers);
    List<BikerResponseDto> toBikerResponseDtoList(List<Bikers> bikers);
}
