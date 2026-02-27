package com.tecylab.product_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GraphQLConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");  // Permite solicitudes desde cualquier origen
        config.addAllowedMethod("*");  // Permite todos los métodos
        config.addAllowedHeader("*");  // Permite todos los encabezados
        source.registerCorsConfiguration("/graphql", config);  // Aplica solo a la ruta /graphql
        return new CorsFilter(source);
    }
}
