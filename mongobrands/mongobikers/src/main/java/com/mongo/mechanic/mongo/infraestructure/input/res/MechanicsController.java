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
@RequestMapping("api/mechanic/v1")
public class MechanicsController {
    private final IMechanicHandler mechanicHandler;
    @GetMapping
    public ResponseEntity<List<?>> getMechanics(){
        List<MechanicResponseDto> listMechanics = mechanicHandler.findAllMechanics();
        return new ResponseEntity(listMechanics,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<?>> getMechanicsForName(@PathVariable String name){
        return new ResponseEntity(mechanicHandler.findByName(name),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> CreateMechanics(@RequestBody MechanicRequestDto mechanicRequestDto){
        mechanicHandler.createMechanic(mechanicRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
