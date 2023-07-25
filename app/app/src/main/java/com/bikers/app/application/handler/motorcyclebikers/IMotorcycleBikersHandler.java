package com.bikers.app.application.handler.motorcyclebikers;

import com.bikers.app.application.dto.motorcyclebikers.request.MotorcycleBikersRequestDto;
import com.bikers.app.application.dto.motorcyclebikers.response.MotorcycleBikersResponseDto;

import java.util.List;

public interface IMotorcycleBikersHandler {
    public List<MotorcycleBikersResponseDto> findAllMotorcycleBikers();
    public void  saveMotorcycleBikers(MotorcycleBikersRequestDto motorcycleBiker);
}
