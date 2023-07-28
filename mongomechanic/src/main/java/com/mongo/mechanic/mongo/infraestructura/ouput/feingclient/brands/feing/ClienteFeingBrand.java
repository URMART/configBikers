package com.mongo.mechanic.mongo.infraestructura.ouput.feingclient.brands.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brand-service", url = "${feign.module.brand}")
public interface ClienteFeingBrand {
    @GetMapping("/{name}")
    Brand getBransForName(@PathVariable String name);
}
