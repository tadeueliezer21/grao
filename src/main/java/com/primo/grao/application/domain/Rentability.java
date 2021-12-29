package com.primo.grao.application.domain;

import com.primo.grao.adapters.dto.RentabilityDTO;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rentability {
    
    private BigDecimal inputValue;
    private BigDecimal feel;
    private Integer weeks;

    public Rentability parseToRentability(RentabilityDTO rentabilityDTO) throws IllegalArgumentException{

        if(rentabilityDTO.getFeel() == null ||
                rentabilityDTO.getFeel().compareTo(BigDecimal.ZERO) <= 0 ||
                rentabilityDTO.getFeel().compareTo(BigDecimal.valueOf(100)) > 0) {
            throw new IllegalArgumentException("the rate cannot be empty or less than 0 and greater than 100");

        } else if(rentabilityDTO.getWeeks() == null || rentabilityDTO.getWeeks() <= 0) {
            throw new IllegalArgumentException("the week quantity cannot be empty or less than zero");

        } else if(rentabilityDTO.getInputValue() == null || rentabilityDTO.getInputValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("the amount invested cannot be empty or less than zero");
        }

        return Rentability.builder()
                .feel(rentabilityDTO.getFeel())
                .weeks(rentabilityDTO.getWeeks())
                .inputValue(rentabilityDTO.getInputValue()).build();
    }
}
