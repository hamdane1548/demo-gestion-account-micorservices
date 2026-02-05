package net.oussama.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                        .route(r-> r
                                .path("/eazybank/account/**")
                                .filters(f -> f.rewritePath("/eazybank/account/(?<segment>.*)", "/${segment}")
                                        .addResponseHeader("Content-Type", "application/json;charset=UTF-8")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())

                                )
                                .uri("lb://ACCOUNT")
                        )
                .route(r-> r
                        .path("/eazybank/cards/**")
                        .filters(f -> f.rewritePath("/eazybank/cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("Content-Type", "application/json;charset=UTF-8")
                                .addResponseHeader("hello", "world")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                        )
                        .uri("lb://CARDS")
                )
                .route(r-> r
                        .path("/eazybank/loans/**")
                        .filters(f -> f.rewritePath("/eazybank/loans/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("Content-Type", "application/json;charset=UTF-8")
                                .addResponseHeader("hello", "world")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())

                        )
                        .uri("lb://LOANS")
                )
                .build();



    }

}
