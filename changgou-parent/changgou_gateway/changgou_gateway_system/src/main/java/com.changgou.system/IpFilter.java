package com.changgou.system;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.InetSocketAddress;

/**
 * @author : Gordon Zhang
 * @Date: 5/5/2020 9:07 AM
 * @Version 1.0
 */
public class IpFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("go through first filter");
        ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
        InetSocketAddress address = request.getRemoteAddress();
        System.out.println("ip" + address.getHostName());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
