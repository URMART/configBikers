package com.bikers.app.infraestructure.input.rest;

import com.bikers.app.application.dto.motorcycle.request.MotorcycleRequestDto;
import com.bikers.app.application.dto.motorcycle.response.MotorcycleResponseDto;
import com.bikers.app.application.handler.motorcycle.IMotorcycleHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "obtener una lista de motorcycle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list objects found", content = @Content),
            @ApiResponse(responseCode = "409", description = "list objects not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<?>> findAllMotorcicle(){
        List<MotorcycleResponseDto> listMotorcycle = motorcycleHandler.getAllMotorcycles();
        return new ResponseEntity<>(listMotorcycle, HttpStatus.OK);
    }


    @Operation(summary = "añadir una nueva motorcycle")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad_request", content = @Content)
    })
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



    @Operation(summary = "obtener una  motorcycle por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object not exists", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdMotorcycle(@PathVariable Long id) {
        return new ResponseEntity<>(motorcycleHandler.getMotorcycleById(id),HttpStatus.OK);
    }




}
