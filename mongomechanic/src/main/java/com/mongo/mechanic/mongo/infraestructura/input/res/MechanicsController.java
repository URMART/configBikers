package com.mongo.mechanic.mongo.infraestructura.input.res;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;
import com.mongo.mechanic.mongo.application.hadler.IMechanicHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/app/v1/mechanic")
public class MechanicsController {
    private final IMechanicHandler mechanicHandler;
    @GetMapping
    public ResponseEntity<List<?>> getMechanics(){
        List<MechanicResponseDto> listMechanics = mechanicHandler.findAllMechanics();
        return new ResponseEntity(listMechanics,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public MechanicResponseDto getMechanicsForName(@PathVariable String name){
        return mechanicHandler.findByName(name);
    }

    @PostMapping
    public ResponseEntity<?> CreateMechanics(@RequestBody MechanicRequestDto mechanicRequestDto){
        mechanicHandler.createMechanic(mechanicRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
