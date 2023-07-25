package com.bikers.app.application.dto.motorcyclebikers.response;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.model.Motorcycle;
import lombok.Data;

@Data
public class MotorcycleBikersResponseDto {
    private Bikers idBikers;
    private Motorcycle idMortorcycle;
}
