package com.primo.grao.application.services;

import com.primo.grao.adapters.dto.RentabilityDTO;
import com.primo.grao.application.services.impl.RentabilityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class RentabilityServiceTest {

    @Test
    @DisplayName("Test to calc rentability by service with Success")
    void testToCalcRentabilityByServiceWithSuccess() {

        RentabilityServiceImpl rentabilityService = new RentabilityServiceImpl();

        RentabilityDTO rentabilityDTO = RentabilityDTO.builder()
                .inputValue(BigDecimal.valueOf(200))
                .feel(BigDecimal.valueOf((4.25)))
                .weeks(36)
                .build();

        rentabilityDTO = rentabilityService.getRentability(rentabilityDTO);

        Assertions.assertEquals(206.03522188221777, rentabilityDTO.getOutputValue());

    }

}

