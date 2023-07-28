package com.mongo.mechanic.mongo.infraestructura.input.res;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;
import com.mongo.mechanic.mongo.application.hadler.IMechanicHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "obtener una lista de mechanics")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list objects found", content = @Content),
            @ApiResponse(responseCode = "409", description = "list objects not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<?>> getMechanics(){
        List<MechanicResponseDto> listMechanics = mechanicHandler.findAllMechanics();
        return new ResponseEntity(listMechanics,HttpStatus.OK);
    }
    @Operation(summary = "obtener una  mechancic por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object not exists", content = @Content)
    })
    @GetMapping("/{name}")
    public MechanicResponseDto getMechanicsForName(@PathVariable String name){
        return mechanicHandler.findByName(name);
    }
    @Operation(summary = "añadir un nueco  mechanic")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad_request", content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> createMechanics(@RequestBody MechanicRequestDto mechanicRequestDto){
        mechanicHandler.createMechanic(mechanicRequestDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
