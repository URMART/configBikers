package com.mongo.brand.mongo.infraestructura.input.res;

import com.mongo.brand.mongo.application.dto.BrandRequestDto;
import com.mongo.brand.mongo.application.dto.BrandResponseDto;
import com.mongo.brand.mongo.application.hadler.IBrandHandler;
import com.mongo.brand.mongo.domain.model.Brand;
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
@RequestMapping("api/app/v1/brand")
public class BrandController {

    private final IBrandHandler brandHandler;
    @Operation(summary = "obtener una lista de brands")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list objects found", content = @Content),
            @ApiResponse(responseCode = "409", description = "list objects not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<?>> getBrands(){
        List<BrandResponseDto> listBrands = brandHandler.findAllBrand();
        return new ResponseEntity<>(listBrands,HttpStatus.OK);
    }



    @Operation(summary = "obtener una  brand por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object not exists", content = @Content)
    })
    @GetMapping("/{name}")
    public BrandResponseDto getBransForName(@PathVariable String name){
        return brandHandler.findByName(name);
    }



    @Operation(summary = "añadir una nueva brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "400", description = "bad_request", content = @Content)
    })
    @PostMapping
    public ResponseEntity<?> createBrands(@RequestBody BrandRequestDto brandRequestDto){
        brandHandler.createBrand(brandRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
