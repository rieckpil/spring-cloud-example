package de.rieckpil;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("STRING-GENERATOR-MICROSERVICE")
public interface StringGeneratorClient {

    @GetMapping("/")
    public String getWord();
}
