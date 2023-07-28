package com.bikers.app.application.handler.bikers;

import com.bikers.app.application.dto.bikers.request.BikerRequestDto;
import com.bikers.app.application.dto.bikers.response.BikerResponseDto;
import com.bikers.app.application.mapper.bikers.IBikerRequestMapper;
import com.bikers.app.application.mapper.bikers.IBikerResponseMapper;
import com.bikers.app.domain.api.IBikersServicePort;
import com.bikers.app.common.exeptions.BusinessException;
import com.bikers.app.infraestructure.output.clientfeing.mechanic.ClientFeingMechanic;
import com.bikers.app.infraestructure.output.clientfeing.mechanic.Mechanic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BikersHandlerImp implements IBikersHandler {

    private final IBikersServicePort bikersServicePort;
    private final IBikerRequestMapper bikerRequestMapper;
    private final IBikerResponseMapper bikerResponseMapper;
    private final ClientFeingMechanic clientFeingMechanic;

    @Override
    public Optional<BikerResponseDto> findById(Long id) {
        return Optional.of(bikerResponseMapper.toBikerResponseDto(bikersServicePort.findById(id).orElseThrow()));
    }

    @Override
    public List<BikerResponseDto> findAllBikers() {
        return bikerResponseMapper.toBikerResponseDtoList(bikersServicePort.findAllBikers());
    }

    @Override
    public void saveBiker(BikerRequestDto bikerRequestDto) {
        try {
            Mechanic mechanic = clientFeingMechanic.getMechanicsForName(bikerRequestDto.getMechanic());
            bikerRequestDto.setMechanic(mechanic.getNameMechanical());
        }catch (Exception e) {
            throw new BusinessException(e.getMessage(), "BAD_REQUEST", HttpStatus.BAD_REQUEST, false);
        }
        bikersServicePort.saveBiker(bikerRequestMapper.toBikers(bikerRequestDto));
    }

    @Override
    public void deleteBiker(Long id) {

        try {
            bikersServicePort.deleteBiker(id);
        }catch (Exception e) {
            throw new BusinessException(e.getMessage(), "NOT_FOUND", HttpStatus.NOT_FOUND, false);
        }

    }
}
