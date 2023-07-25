package com.bikers.app.application.handler.motorcycle;



import com.bikers.app.application.dto.motorcycle.request.MotorcycleRequestDto;
import com.bikers.app.application.dto.motorcycle.response.MotorcycleResponseDto;

import java.util.List;

public interface IMotorcycleHandler {

    public List<MotorcycleResponseDto> getAllMotorcycles();
    public MotorcycleResponseDto getMotorcycleById(Long id);
    public void saveMotorcycle(MotorcycleRequestDto motorcycle);
}
