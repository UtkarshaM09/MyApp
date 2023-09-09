package com.stackroute.Gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    RouteLocator getRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/auth-app/**")
                        .uri("lb://authentication-app"))
                .route(p->p
                        .path("/product-app/**")
                        .uri("lb://product-app"))
                .build();
    }

}
