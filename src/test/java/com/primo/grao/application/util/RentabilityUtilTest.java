package com.primo.grao.application.util;

import com.primo.grao.application.domain.Rentability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class RentabilityUtilTest {

    @Test
    @DisplayName("Test to calc rentability with success")
    void testToCalcRentabilityWithSuccess() {
        Assertions.assertEquals(103.01761094110888, RentabilityUtil
                .calc(Rentability.builder()
                        .weeks(36).feel(BigDecimal.valueOf(4.25))
                        .inputValue(BigDecimal.valueOf(100))
                        .build()));
    }

}
