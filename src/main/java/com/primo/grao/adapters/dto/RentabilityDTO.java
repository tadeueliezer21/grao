package com.primo.grao.adapters.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
public class RentabilityDTO {

    private BigDecimal inputValue;
    private Double outputValue;

    private BigDecimal feel;
    private Integer weeks;
    private Integer days;

}
