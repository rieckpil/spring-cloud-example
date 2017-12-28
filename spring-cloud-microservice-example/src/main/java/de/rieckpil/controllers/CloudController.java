package de.rieckpil.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudController {

    @Value("${lucky-word}")
    private String cloudWord;

    @GetMapping("/cloud")
    public String sayHelloFromCloud() {
        return cloudWord;
    }
}
