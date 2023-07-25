package com.bikers.app.application.handler.motorcyclebikers;

import com.bikers.app.application.dto.motorcyclebikers.request.MotorcycleBikersRequestDto;
import com.bikers.app.application.dto.motorcyclebikers.response.MotorcycleBikersResponseDto;
import com.bikers.app.application.mapper.motorcyclebikers.IMotorcycleBikersRequestMapper;
import com.bikers.app.application.mapper.motorcyclebikers.IMotorcycleBikersResponseMapper;
import com.bikers.app.domain.api.IMotorcycleBikersServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class MotorcycleBikersHandlerImp implements IMotorcycleBikersHandler{

    private final IMotorcycleBikersResponseMapper motorcycleBikersResponseMapper;
    private final IMotorcycleBikersRequestMapper motorcycleBikersRequestMapper;
    private final IMotorcycleBikersServicePort bikersServicePort;
    @Override
    public List<MotorcycleBikersResponseDto> findAllMotorcycleBikers() {
        return motorcycleBikersResponseMapper
                .toMotorcycleBikersResponseDto(bikersServicePort.findAllMotorcycleBikers());
    }

    @Override
    public void saveMotorcycleBikers(MotorcycleBikersRequestDto motorcycleBiker) {
        motorcycleBikersRequestMapper.toMotorcycleBiker(motorcycleBiker);
    }
}
