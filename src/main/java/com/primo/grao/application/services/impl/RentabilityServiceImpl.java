package com.primo.grao.application.services.impl;

import com.primo.grao.adapters.dto.RentabilityDTO;
import com.primo.grao.application.domain.Rentability;
import com.primo.grao.application.services.RentabilityService;
import com.primo.grao.application.util.RentabilityUtil;
import org.apache.commons.logging.LogFactory;

public class RentabilityServiceImpl extends AbstractLoggerService implements RentabilityService {

    public RentabilityServiceImpl() {
        super(LogFactory.getLog(RentabilityServiceImpl.class));
    }

    public RentabilityDTO getRentability(RentabilityDTO rentabilityDTO) throws IllegalArgumentException {

        log.info("getRentability method");
        Rentability rentability = new Rentability().parseToRentability(rentabilityDTO);

        rentabilityDTO.setDays(RentabilityUtil.getDays(rentability));
        rentabilityDTO.setOutputValue(RentabilityUtil.calc(rentability));

        log.info("getRentability method success");

        return rentabilityDTO;
    }
}
