package com.primo.grao.adapters.input;

import com.primo.grao.adapters.dto.RentabilityDTO;
import com.primo.grao.application.services.RentabilityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RentabilityController {

    private static final Log log = LogFactory.getLog(RentabilityController.class);

    RentabilityService rentabilityService;

    @PostMapping(path = "calc-feel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RentabilityDTO> calculateRentability(@RequestBody RentabilityDTO rentabilityDTO) {
        try {
            log.info("calculateRentability method");
            return ResponseEntity.status(HttpStatus.OK).body(rentabilityService.getRentability(rentabilityDTO));

        } catch (IllegalArgumentException ex) {
            log.error("calculateRentability failed " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        } catch (Exception ex) {
            log.error("internal error " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Autowired
    public void setRentabilityService(RentabilityService rentabilityService) {
        this.rentabilityService = rentabilityService;
    }
}
