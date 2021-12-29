package com.primo.grao.application.util;

import com.primo.grao.application.domain.Rentability;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RentabilityUtil {

    private static final Log log = LogFactory.getLog(RentabilityUtil.class);

    private RentabilityUtil() {
    }

    private static final BigDecimal YEARLY_WORKING_DAYS = BigDecimal.valueOf(252);
    private static final Integer WEEK_WORKING_DAYS = 5;

    public static Double calc(Rentability rentability) {

        log.info("calc method");

        BigDecimal feel = rentability.getFeel().divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_DOWN).add(BigDecimal.valueOf(1));
        BigDecimal targetDays = BigDecimal.valueOf(getDays(rentability));
        BigDecimal inputValue = rentability.getInputValue();

        double response = Math.pow(feel.doubleValue(),
                targetDays.divide(YEARLY_WORKING_DAYS, 10, RoundingMode.HALF_DOWN)
                        .doubleValue()) * inputValue.doubleValue();

        log.info("feel => " + feel
                + " targetDays => " + targetDays
                + " inputValue => " + inputValue
                + " response => " + response);

        log.info("calc method success");

        return response;
    }

    public static Integer getDays(Rentability rentability) {
        return rentability.getWeeks() * WEEK_WORKING_DAYS;
    }


}
