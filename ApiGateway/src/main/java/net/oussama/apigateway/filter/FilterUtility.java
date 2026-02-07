package net.oussama.apigateway.filter;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "eazybank-id-request";
    public static String CORRELATION_ID(HttpHeaders headers) {
        if (headers.get(CORRELATION_ID) != null) {
            List<String> headerValues = headers.get(CORRELATION_ID);
            return headerValues.stream().findFirst().get();
        }else {
            return null;
        }
    }
    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }
    public  ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
        return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
    }
}
