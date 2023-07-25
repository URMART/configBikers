package com.bikers.app.application.handler.motorcycle;

import com.bikers.app.application.dto.motorcycle.request.MotorcycleRequestDto;
import com.bikers.app.application.dto.motorcycle.response.MotorcycleResponseDto;
import com.bikers.app.application.mapper.motorcycle.IMotorcycleRequestMapper;
import com.bikers.app.application.mapper.motorcycle.IMotorcycleResponseMapper;
import com.bikers.app.common.exeptions.BusinessException;
import com.bikers.app.domain.api.IMotorcycleServicePort;
import com.bikers.app.infraestructure.output.clientfeing.brands.feing.Brand;
import com.bikers.app.infraestructure.output.clientfeing.brands.feing.ClienteFeingBrand;
import com.bikers.app.infraestructure.output.clientfeing.brands.restemplate.IBrandRestemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class MotorcycleHandlerImp implements IMotorcycleHandler{

    private final IMotorcycleServicePort motorcycleServicePort;
    private final IMotorcycleRequestMapper motorcycleRequestMapper;
    private final IMotorcycleResponseMapper motorcycleResponseMapper;
    private final ClienteFeingBrand clienteFeingBrand;

    @Override
    public List<MotorcycleResponseDto> getAllMotorcycles() {
        return motorcycleResponseMapper.toMotorcycleResponseList(motorcycleServicePort.getAllMotorcycles());
    }

    @Override
    public MotorcycleResponseDto getMotorcycleById(Long id) {
        return motorcycleResponseMapper.toMotorcycleResponse(motorcycleServicePort.getMotorcycleById(id));
    }

    @Override
    public void saveMotorcycle(MotorcycleRequestDto motorcycle) {
        try {
            Brand brand = clienteFeingBrand.getBransForName(motorcycle.getIdBrand());
            motorcycle.setIdBrand(brand.getNameBrand());

        }catch (Exception e) {
            throw new BusinessException(e.getMessage(), "BAD_REQUEST", HttpStatus.BAD_REQUEST, false);
        }
        motorcycleServicePort.saveMotorcycle(motorcycleRequestMapper.toMotorcycle(motorcycle));
    }
}
