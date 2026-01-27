package net.oussama.serverconfid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ServerConfidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerConfidApplication.class, args);
    }

}
