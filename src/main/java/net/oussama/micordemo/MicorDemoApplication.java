package net.oussama.micordemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import net.oussama.micordemo.dtos.AccountContactInfoDTo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableConfigurationProperties(value = AccountContactInfoDTo.class)
@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Account REST API microserivces",
                description = "bank account rest api microservices",
                version = "v1",
                contact = @Contact(
                        name = "oussama hamane",
                        email = "oussamahadane128@gmail.com",
                        url = "oussama.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        )
)
@EnableJpaAuditing(auditorAwareRef = "auditAwardImpl")
public class MicorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicorDemoApplication.class, args);
    }

}
