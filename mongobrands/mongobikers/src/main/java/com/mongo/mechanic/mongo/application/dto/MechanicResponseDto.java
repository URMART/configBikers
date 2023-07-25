package com.mongo.mechanic.mongo.application.dto;

import lombok.Data;

@Data
public class MechanicResponseDto {
    private String id;
    private String nameMechanical;

    private String Email;

    private String numberPhone;
    private String specialSkillBrand;
}
