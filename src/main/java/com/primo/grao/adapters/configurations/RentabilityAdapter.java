package com.primo.grao.adapters.configurations;


import com.primo.grao.GraoApplication;
import com.primo.grao.application.services.impl.RentabilityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = GraoApplication.class)
public class RentabilityAdapter {

    @Bean
    RentabilityServiceImpl rentabilityService () {
        return new RentabilityServiceImpl();
    }


}
