package de.rieckpil.controllers;

import de.rieckpil.services.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class CloudController {

    @Value("${lucky-word}")
    private String cloudWord;

    @Value("${other.value}")
    private String otherValue;

    @Autowired
    private CloudService cloudService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cloud")
    public String sayHelloFromCloud() {
        return cloudWord + "   " + otherValue;
    }

    @GetMapping("/cloud-eureka")
    public String sayHelloFromCloudWithEurekaDiscovery() {
        // return "RANDOM WORD: " + getWord("STRING-GENERATOR-MICROSERVICE");
        return cloudService.getRandomWord();
    }

}
