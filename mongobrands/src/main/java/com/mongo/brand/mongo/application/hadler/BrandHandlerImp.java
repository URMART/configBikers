package com.mongo.brand.mongo.application.hadler;

import com.mongo.brand.mongo.application.dto.BrandRequestDto;
import com.mongo.brand.mongo.application.dto.BrandResponseDto;
import com.mongo.brand.mongo.application.mapper.IBrandRequestMapper;
import com.mongo.brand.mongo.application.mapper.IBrandResponseMapper;
import com.mongo.brand.mongo.common.exeptions.BusinessException;
import com.mongo.brand.mongo.domain.api.IBrandPortService;
import com.mongo.brand.mongo.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class BrandHandlerImp implements IBrandHandler {

    private final IBrandPortService brandPortService;
    private final IBrandResponseMapper brandResponseMapper;

    private final IBrandRequestMapper brandRequestMapper;

    @Override
    public List<BrandResponseDto> findAllBrand() {
        return brandResponseMapper
               .toBrandDtoList(brandPortService.findAllBrand());
    }

    @Override
    public BrandResponseDto findByName(String name) {

        Brand brand = brandPortService.findByName(name);
        if (brand!=null) {
            return brandResponseMapper.toBrandResposeDto(brand);
        }
        throw new BusinessException("La marca no existe", "NOT_FOUND", HttpStatus.NOT_FOUND, false);

    }

    @Override
    public void createBrand(BrandRequestDto brand) {
        brandPortService.createBrand(brandRequestMapper.toBrand(brand));
    }
}
