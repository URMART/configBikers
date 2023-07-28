package com.bikers.app.infraestructure.input.rest;

import com.bikers.app.application.dto.bikers.request.BikerRequestDto;
import com.bikers.app.application.dto.bikers.response.BikerResponseDto;
import com.bikers.app.application.handler.bikers.IBikersHandler;
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
@RequestMapping("api/app/v1/bikers")
public class BikersController {

    private  final IBikersHandler bikersHandler;
    @Operation(summary = "obtener una lista de bikers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list objects found", content = @Content),
            @ApiResponse(responseCode = "409", description = "list objects not found", content = @Content)
    })
    @GetMapping
    public List<BikerResponseDto> getAllBikers(){
        return bikersHandler.findAllBikers();
    }

    @Operation(summary = "añadir un nuevo biker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad_request", content = @Content)
    })
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


    @Operation(summary = "obtener un  biker por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object not exists", content = @Content)
    })
    @GetMapping("/{id}")
    public  ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(bikersHandler.findById(id),HttpStatus.OK);
    }



    @Operation(summary = "eliminar un  biker por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object deleted", content = @Content),
            @ApiResponse(responseCode = "409", description = "Bad request", content = @Content)
    })
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Long id){
        bikersHandler.deleteBiker(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
