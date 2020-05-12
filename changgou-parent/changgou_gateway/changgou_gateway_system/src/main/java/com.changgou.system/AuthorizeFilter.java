package com.changgou.system;

import com.changgou.system.util.JWTUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author : Gordon Zhang
 * @Date: 5/7/2020 10:15 AM
 * @Version 1.0
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();

        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        if (serverHttpRequest.getURI().getPath().contains("/admin/login")) {
            return chain.filter(exchange);
        }
        HttpHeaders httpHeaders = serverHttpRequest.getHeaders();
        String token = httpHeaders.getFirst(AUTHORIZE_TOKEN);
        if (StringUtils.isEmpty(token)) {
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return serverHttpResponse.setComplete();
        }

        try {
            JWTUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return serverHttpResponse.setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
