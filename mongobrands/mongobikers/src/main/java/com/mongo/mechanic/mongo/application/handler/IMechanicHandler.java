package com.mongo.mechanic.mongo.application.hadler;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;


import java.util.List;


public interface IMechanicHandler {

   public List<MechanicResponseDto> findAllMechanics();
   public MechanicResponseDto findByName(String name);
   public  void createMechanic(MechanicRequestDto mechanic);
}
