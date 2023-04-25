package org.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("============= in filter ================");
//        exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//        return exchange.getResponse().setComplete();
        return chain.filter(exchange);
    }

    /**
     * 优先级 数字越小优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
