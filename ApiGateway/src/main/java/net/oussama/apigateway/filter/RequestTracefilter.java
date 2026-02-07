package net.oussama.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Component
public class RequestTracefilter implements GlobalFilter {
    @Autowired
    private FilterUtility filterUtility;
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestTracefilter.class);
    private static final Logger logger = LoggerFactory.getLogger(RequestTracefilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        if(checkId(headers)){
            System.out.println("le request wiht the id"+FilterUtility.CORRELATION_ID(headers));
        }else{
            String id_request = generateId();
            exchange = filterUtility.setCorrelationId(exchange, id_request);
        }
        return chain.filter(exchange);
    }
    private boolean checkId(HttpHeaders headers) {
        if(FilterUtility.CORRELATION_ID(headers)!=null){
            return true;
    }else {
            return false;
        }
    }
    private String generateId(){
        return UUID.randomUUID().toString();
    }
}
