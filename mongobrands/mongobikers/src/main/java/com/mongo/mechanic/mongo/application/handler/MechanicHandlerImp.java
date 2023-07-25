package com.mongo.mechanic.mongo.application.hadler;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;
import com.mongo.mechanic.mongo.application.mapper.IMechanicRequestMapper;
import com.mongo.mechanic.mongo.application.mapper.IMechanicResponseMapper;
import com.mongo.mechanic.mongo.domain.api.IMechanicPortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class MechanicHandlerImp implements  IMechanicHandler{

    private final IMechanicPortService mechanicPortService;
    private final IMechanicResponseMapper mechanicResponseMapper;

    private final IMechanicRequestMapper mechanicRequestMapper;

    @Override
    public List<MechanicResponseDto> findAllMechanics() {
        return mechanicResponseMapper
               .toMechanicsDtoList(mechanicPortService.findAllMechanics());
    }

    @Override
    public MechanicResponseDto findByName(String name) {
        return mechanicResponseMapper.toMechanicResposeDto(mechanicPortService.findByName(name));
    }

    @Override
    public void createMechanic(MechanicRequestDto mechanic) {
        mechanicPortService.createMechanic(mechanicRequestMapper.toMechanic(mechanic));
    }
}
