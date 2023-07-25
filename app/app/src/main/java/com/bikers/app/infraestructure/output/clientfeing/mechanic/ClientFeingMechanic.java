package com.bikers.app.infraestructure.output.clientfeing.mechanic;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "mechanic-service", url = "${feign.module.mechanic}")
public interface ClientFeingMechanic {
    @GetMapping("/{name}")
    Mechanic getMechanicsForName(@PathVariable String name);
}
