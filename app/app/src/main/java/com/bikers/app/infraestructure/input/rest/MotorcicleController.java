package com.bikers.app.infraestructure.input.rest;

import com.bikers.app.application.dto.motorcycle.request.MotorcycleRequestDto;
import com.bikers.app.application.dto.motorcycle.response.MotorcycleResponseDto;
import com.bikers.app.application.handler.motorcycle.IMotorcycleHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/app/v1/motorcycle")
public class MotorcicleController {

    private final IMotorcycleHandler motorcycleHandler;

    @GetMapping
    public ResponseEntity<List<?>> findAllMotorcicle(){
        List<MotorcycleResponseDto> listMotorcycle = motorcycleHandler.getAllMotorcycles();
        return new ResponseEntity<>(listMotorcycle, HttpStatus.OK);
    }



    @CircuitBreaker(name = "brandB", fallbackMethod = "fallBackPostBrand")
    @PostMapping
    public ResponseEntity<?> createMotorcycle(@Valid @RequestBody MotorcycleRequestDto dto) {
        motorcycleHandler.saveMotorcycle(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private ResponseEntity<?> fallBackPostBrand(@Valid @RequestBody MotorcycleRequestDto dto,RuntimeException e){
        return new ResponseEntity("No se pudo crear la motocicleta  porque el microservicio de  marca no funciona"
                ,HttpStatus.BAD_GATEWAY);
    }




    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdMotorcycle(@PathVariable Long id) {
        return new ResponseEntity<>(motorcycleHandler.getMotorcycleById(id),HttpStatus.OK);
    }




}
