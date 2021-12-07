package com.javatechie.saga.order.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    MapperFacade mapper() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().useBuiltinConverters(false).build();
        return mapperFactory.getMapperFacade();
    }
}
