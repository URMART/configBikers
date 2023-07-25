
package com.mongo.brand.mongo.infraestructura.configuration.config;

import com.mongo.brand.mongo.domain.api.IBrandPortService;
import com.mongo.brand.mongo.domain.spi.IBrandPortPersistens;
import com.mongo.brand.mongo.domain.usecase.BrandUseCase;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.adapter.BrandAdapaterMongoDataJpa;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.adapter.BrandAdapterMongoTemplate;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.mapper.IBrandEntityMapper;
import com.mongo.brand.mongo.infraestructura.ouput.jpa.repository.IBrandEntityJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final IBrandEntityJpa brandEntityJpa;
    private final IBrandEntityMapper brandEntityMapper;
    private final MongoTemplate mongoTemplate;

    @Bean
    @Qualifier("dataJpa")
    public IBrandPortPersistens brandPortPersistensDataJpa(){
        return new BrandAdapaterMongoDataJpa(brandEntityMapper,brandEntityJpa);
    }

    @Bean
    @Qualifier("mongoTemplate")
    public IBrandPortPersistens brandPortPersistensMongoTemplate(){
        return new BrandAdapterMongoTemplate(brandEntityMapper,mongoTemplate);
    }
    @Bean
    public IBrandPortService brandPortService(@Qualifier("mongoTemplate") IBrandPortPersistens brandPortPersistens){
        return  new BrandUseCase(brandPortPersistens);
    }


}
