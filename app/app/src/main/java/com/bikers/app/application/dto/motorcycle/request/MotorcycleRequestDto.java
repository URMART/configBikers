package com.bikers.app.application.dto.motorcycle.request;

import lombok.Data;

@Data
public class MotorcycleRequestDto {
    private Long id;
    private String nameMotorcycle;
    private Boolean State;
    private String idBrand;

}
