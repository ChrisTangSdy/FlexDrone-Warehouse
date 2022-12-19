package com.fdmgroup.flexdronewarehouse.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean Configuration for ModelMapper
 * @author Yutta, Summer
 *
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
