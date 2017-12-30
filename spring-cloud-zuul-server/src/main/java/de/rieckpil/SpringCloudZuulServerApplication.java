package de.rieckpil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulServerApplication.class, args);
    }
}
