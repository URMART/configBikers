package com.mongo.brand.mongo.infraestructura.input.res;

import com.mongo.brand.mongo.application.dto.BrandRequestDto;
import com.mongo.brand.mongo.application.dto.BrandResponseDto;
import com.mongo.brand.mongo.application.hadler.IBrandHandler;
import com.mongo.brand.mongo.domain.model.Brand;
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
    @GetMapping
    public ResponseEntity<List<?>> getBrands(){
        List<BrandResponseDto> listBrands = brandHandler.findAllBrand();
        return new ResponseEntity<>(listBrands,HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public BrandResponseDto getBransForName(@PathVariable String name){
        return brandHandler.findByName(name);
    }

    @PostMapping
    public ResponseEntity<?> createBrands(@RequestBody BrandRequestDto brandRequestDto){
        brandHandler.createBrand(brandRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
