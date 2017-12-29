package de.rieckpil.services;

import de.rieckpil.StringGeneratorClient;
import org.springframework.stereotype.Service;

@Service
public class CloudService {

    private StringGeneratorClient stringGeneratorClient;

    public CloudService(StringGeneratorClient stringGeneratorClient) {
        this.stringGeneratorClient = stringGeneratorClient;
    }

    public String getRandomWord(){
        //return restTemplate.getForObject("http://" + service, String.class);

        return "RANDOM WORD IS: " + stringGeneratorClient.getWord();
    }
}
