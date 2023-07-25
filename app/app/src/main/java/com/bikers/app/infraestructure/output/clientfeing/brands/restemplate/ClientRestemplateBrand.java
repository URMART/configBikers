package com.bikers.app.infraestructure.output.clientfeing.brands.restemplate;

import com.bikers.app.infraestructure.output.clientfeing.brands.feing.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class ClientRestemplateBrand implements  IBrandRestemplate{


    private final RestTemplate restTemplate;
    @Override
    public Brand getBrand(String id) {
        return restTemplate
                .getForObject("localhost:8084/api/brand/v1/",
                        Brand.class,id);
    }


}
