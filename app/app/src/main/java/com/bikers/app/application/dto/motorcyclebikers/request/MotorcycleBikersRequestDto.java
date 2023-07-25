package com.bikers.app.application.dto.motorcyclebikers.request;

import com.bikers.app.domain.model.Bikers;
import com.bikers.app.domain.model.Motorcycle;
import lombok.Data;

@Data
public class MotorcycleBikersRequestDto {
    private Long id;
    private Bikers idBikers;
    private Motorcycle idMortorcycle;
}
