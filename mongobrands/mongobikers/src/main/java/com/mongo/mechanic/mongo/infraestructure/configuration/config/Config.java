
package com.mongo.mechanic.mongo.infraestructura.configuration.config;

import com.mongo.mechanic.mongo.domain.api.IMechanicPortService;
import com.mongo.mechanic.mongo.domain.spi.IMechanicPortPersistens;
import com.mongo.mechanic.mongo.domain.usecase.MechanicUseCase;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.adapter.MechanicAdapater;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.mapper.IMechanicEntityMapper;
import com.mongo.mechanic.mongo.infraestructura.ouput.jpa.repository.IMechanicEntityJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final IMechanicEntityJpa mechanicEntityJpa;
    private final IMechanicEntityMapper mechanicEntityMapper;

    @Bean
    public IMechanicPortPersistens mechanicPortPersistens(){
        return new MechanicAdapater(mechanicEntityMapper,mechanicEntityJpa);
    }
    @Bean
    public IMechanicPortService mechanicPortService(){
        return  new MechanicUseCase(mechanicPortPersistens());
    }


}
