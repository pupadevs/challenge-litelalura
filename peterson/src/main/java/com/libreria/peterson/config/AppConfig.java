package com.libreria.peterson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //El Bean RestTemplate  que se mana del component, inicia el servicio
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
