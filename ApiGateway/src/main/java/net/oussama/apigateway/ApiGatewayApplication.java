package net.oussama.apigateway;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.codec.multipart.Part;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
@CrossOrigin("*")
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
                                        .addRequestHeader("user", UUID.randomUUID().toString())
                                        .circuitBreaker(cr -> cr.setName("accountcircuitbreaker"))
                                        .requestRateLimiter(config -> {
                                            config.setRateLimiter(redisRateLimiter()).setKeyResolver(userkeyResolver());

                                        })
                                )

                                .uri("lb://ACCOUNT")

                        )
                .route(r-> r
                        .path("/eazybank/cards/**")
                        .filters(f -> f.rewritePath("/eazybank/cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("Content-Type", "application/json;charset=UTF-8")
                                .addResponseHeader("hello", "world")
                                .retry(retryConfig -> {
                                    retryConfig.setRetries(3);
                                    retryConfig.setMethods(HttpMethod.GET);
                                    retryConfig.setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true);
                                })
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
@Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1,1,1);
}
@Bean
    KeyResolver userkeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getHeaders().getFirst("user")).defaultIfEmpty("an");
}
}
