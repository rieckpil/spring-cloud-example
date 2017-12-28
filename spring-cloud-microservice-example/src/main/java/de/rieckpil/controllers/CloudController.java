package de.rieckpil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class CloudController {

    @Value("${lucky-word}")
    private String cloudWord;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/cloud")
    public String sayHelloFromCloud() {
        return cloudWord;
    }

    @GetMapping("/cloud-eureka")
    public String sayHelloFromCloudWithEurekaDiscovery() {
        return "RANDOM WORD: " + getWord("STRING-GENERATOR-MICROSERVICE");
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
