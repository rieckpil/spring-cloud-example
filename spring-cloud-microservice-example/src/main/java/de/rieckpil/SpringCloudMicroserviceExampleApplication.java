package de.rieckpil;

import de.rieckpil.domain.Player;
import de.rieckpil.domain.Team;
import de.rieckpil.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class SpringCloudMicroserviceExampleApplication {

    @Autowired
    private TeamRepository teamRepository;

    @PostConstruct
    public void init() {
        List<Team> list = new ArrayList<>();

        Set<Player> set = new HashSet<>();
        set.add(new Player("Big Easy", "Showman"));
        set.add(new Player("Buckets", "Guard"));
        set.add(new Player("Dizzy", "Guard"));

        list.add(new Team("Harlem", "Globetrotters", "Dog", set));
        list.add(new Team("Washington","Generals","Bunny", null));

        teamRepository.save(list);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return  new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMicroserviceExampleApplication.class, args);
    }
}
