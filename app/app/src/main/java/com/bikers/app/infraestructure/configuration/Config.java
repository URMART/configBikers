package com.bikers.app.infraestructure.configuration;

import com.bikers.app.domain.api.IBikersServicePort;
import com.bikers.app.domain.api.IMotorcycleBikersServicePort;
import com.bikers.app.domain.api.IMotorcycleServicePort;
import com.bikers.app.domain.model.Motorcycle;
import com.bikers.app.domain.spi.IBikersPersistencePort;
import com.bikers.app.domain.spi.IMotorcycleBikersPersistencePort;
import com.bikers.app.domain.spi.IMotorcyclePersistencePort;
import com.bikers.app.domain.usecase.BikerUseCase;
import com.bikers.app.domain.usecase.MotorcycleBikerUseCase;
import com.bikers.app.domain.usecase.MotorcycleUseCase;
import com.bikers.app.infraestructure.output.jpa.adapter.BikersAdpater;
import com.bikers.app.infraestructure.output.jpa.adapter.MotorcycleAdapter;
import com.bikers.app.infraestructure.output.jpa.adapter.MotorcyclebikersAdapter;
import com.bikers.app.infraestructure.output.jpa.mapper.IBikersEntityMapper;
import com.bikers.app.infraestructure.output.jpa.mapper.IMotorcycleBikersEntityMapper;
import com.bikers.app.infraestructure.output.jpa.mapper.IMotorcycleEntityMapper;
import com.bikers.app.infraestructure.output.jpa.repository.IBikersRepository;
import com.bikers.app.infraestructure.output.jpa.repository.IMotorcycleBikersRepository;
import com.bikers.app.infraestructure.output.jpa.repository.IMotorcycleRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final IBikersRepository bikersRepository;
    private final IBikersEntityMapper bikersEntityMapper;


    private  final IMotorcycleRespository motorcycleRespository;
    private final IMotorcycleEntityMapper motorcycleEntityMapper;


    private final IMotorcycleBikersRepository motorcycleBikersRepository;
    private final IMotorcycleBikersEntityMapper motorcycleBikersEntityMapper;



    // Dependency injection of Bikers Model
    @Bean
    public  IBikersPersistencePort bikersPersistencePort(){
        return new BikersAdpater(bikersEntityMapper,bikersRepository);
    }
    @Bean
    public IBikersServicePort bikersServicePort(){
        return new BikerUseCase(bikersPersistencePort());
    }


    // Dependency injection of Motorcycle Model
    @Bean
    public IMotorcyclePersistencePort motorcyclePersistencePort(){
        return  new MotorcycleAdapter(motorcycleRespository,motorcycleEntityMapper);
    }
    @Bean
    public IMotorcycleServicePort motorcycleServicePort(){
        return  new MotorcycleUseCase(motorcyclePersistencePort());
    }



    // Dependency injection of MotorcycleBikers Model
    @Bean
    public IMotorcycleBikersPersistencePort motorcycleBikersPersistencePort(){
        return new MotorcyclebikersAdapter(motorcycleBikersRepository,motorcycleBikersEntityMapper);
    }

    @Bean
    public IMotorcycleBikersServicePort motorcycleBikersServicePort(){
        return  new MotorcycleBikerUseCase(motorcycleBikersPersistencePort());
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }



}
