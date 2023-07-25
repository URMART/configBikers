package com.bikers.app.application.handler.bikers;

import com.bikers.app.application.dto.bikers.request.BikerRequestDto;
import com.bikers.app.application.dto.bikers.response.BikerResponseDto;


import java.util.List;
import java.util.Optional;

public interface IBikersHandler {

    public Optional<BikerResponseDto> findById(Long id);
    public List<BikerResponseDto> findAllBikers();

    public void saveBiker(BikerRequestDto bikerRequestDto);

    public void deleteBiker(Long id);
}
