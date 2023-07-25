package com.bikers.app.infraestructure.input.rest;

import com.bikers.app.application.dto.bikers.request.BikerRequestDto;
import com.bikers.app.application.dto.bikers.response.BikerResponseDto;
import com.bikers.app.application.handler.bikers.IBikersHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/app/v1/bikers")
public class BikersController {

    private  final IBikersHandler bikersHandler;
    @GetMapping
    public List<BikerResponseDto> getAllBikers(){
        return bikersHandler.findAllBikers();
    }


    @CircuitBreaker(name = "mechanicA", fallbackMethod = "fallBackPostMechanic")
    @PostMapping
    public ResponseEntity<?> createBiker(@Valid @RequestBody BikerRequestDto bikerRequestDto){
        bikersHandler.saveBiker(bikerRequestDto);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    private ResponseEntity<?> fallBackPostMechanic(@Valid @RequestBody BikerRequestDto bikerRequestDto){
        return new ResponseEntity("No se pudo crear el motociclista porque el microservicio de  mecanico no funciona"
                ,HttpStatus.BAD_GATEWAY);
    }



    @GetMapping("/{id}")
    public  ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(bikersHandler.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Long id){
        bikersHandler.deleteBiker(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
