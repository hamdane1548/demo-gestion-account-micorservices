package net.oussama.eurekaserveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserveurApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserveurApplication.class, args);
    }

}
