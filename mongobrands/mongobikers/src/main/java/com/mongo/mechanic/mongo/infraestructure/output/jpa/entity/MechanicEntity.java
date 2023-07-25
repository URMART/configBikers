package com.mongo.mechanic.mongo.infraestructura.ouput.jpa.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Mechanic")
public class MechanicEntity  {
    @Id
    private String id;
    private String nameMechanical;
    private String Email;
    private String numberPhone;
    private String specialSkillBrand;
}
