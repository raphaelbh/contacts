package com.zup.apipoc.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApipocConfiguration {

    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

//    @Bean
//    CreateContactUseCase createContactUseCase(final CreateContactPersistence createContactPersistence) {
//        return new CreateContactService(createContactPersistence);
//    }



}
