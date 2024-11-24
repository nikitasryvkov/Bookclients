package com.bookclients.bookingclients_service.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookclients.bookingclients_service.utils.RateCalculatorImpl;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

    @Bean
    public RateCalculatorImpl rateCalculatorImpl() {
        return new RateCalculatorImpl();
    }
}
