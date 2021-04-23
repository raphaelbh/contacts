package com.zup.apipoc.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiPocConfiguration {

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

}
