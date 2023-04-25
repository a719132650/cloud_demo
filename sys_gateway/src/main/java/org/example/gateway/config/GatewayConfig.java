package org.example.gateway.config;

import org.example.common.enums.Dict;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:
 * @Description:
 * @Date: create in 2023/4/25 14:15
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route(Dict.SERVICE_DEMO.getValue(),
                r -> r.path("/service/*")
                        .uri("http://localhost:8999")).build();

        return routes.build();
    }

}
