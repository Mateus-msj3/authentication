package com.dev.authentication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class ModelMaperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
