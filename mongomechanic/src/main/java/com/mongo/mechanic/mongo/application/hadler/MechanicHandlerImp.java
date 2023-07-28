package com.mongo.mechanic.mongo.application.hadler;

import com.mongo.mechanic.mongo.application.dto.MechanicRequestDto;
import com.mongo.mechanic.mongo.application.dto.MechanicResponseDto;
import com.mongo.mechanic.mongo.application.mapper.IMechanicRequestMapper;
import com.mongo.mechanic.mongo.application.mapper.IMechanicResponseMapper;
import com.mongo.mechanic.mongo.common.exeptions.BusinessException;
import com.mongo.mechanic.mongo.common.exeptions.DomainExeptions;
import com.mongo.mechanic.mongo.domain.api.IMechanicPortService;
import com.mongo.mechanic.mongo.domain.model.Mechanic;
import com.mongo.mechanic.mongo.infraestructura.ouput.feingclient.brands.feing.Brand;
import com.mongo.mechanic.mongo.infraestructura.ouput.feingclient.brands.feing.ClienteFeingBrand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class MechanicHandlerImp implements  IMechanicHandler{

    private final IMechanicPortService mechanicPortService;
    private final IMechanicResponseMapper mechanicResponseMapper;
    private final ClienteFeingBrand clienteFeingBrand;
    private final IMechanicRequestMapper mechanicRequestMapper;

    @Override
    public List<MechanicResponseDto> findAllMechanics() {
        return mechanicResponseMapper
               .toMechanicsDtoList(mechanicPortService.findAllMechanics());
    }

    @Override
    public MechanicResponseDto findByName(String name) {
        Mechanic mechanic = mechanicPortService.findByName(name);
        if (mechanic!=null) {
            return mechanicResponseMapper.toMechanicResposeDto(mechanic);
        }
        throw new BusinessException("El mecanico no existe", "NOT_FOUND", HttpStatus.NOT_FOUND, false);
    }

    @Override
    public void createMechanic(MechanicRequestDto mechanic) {
        try {
            Brand brand = clienteFeingBrand.getBransForName(mechanic.getSpecialSkillBrand());
            mechanic.setSpecialSkillBrand(brand.getNameBrand());
        }catch (Exception e) {
            throw new BusinessException(e.getMessage(), "BAD_REQUEST", HttpStatus.BAD_REQUEST, false);
        }
        mechanicPortService.createMechanic(mechanicRequestMapper.toMechanic(mechanic));
    }
}
