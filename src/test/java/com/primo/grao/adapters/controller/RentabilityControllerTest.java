package com.primo.grao.adapters.controller;

import com.google.gson.Gson;
import com.primo.grao.adapters.dto.RentabilityDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class RentabilityControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test To Calc Rentability By Controller With Success")
    public void testToCalcRentabilityByControllerWithSuccess() throws Exception {

        Gson gson = new Gson();

        RentabilityDTO rentabilityDTO = RentabilityDTO.builder().feel(BigDecimal.valueOf(4.25))
                .weeks(36)
                .inputValue(BigDecimal.valueOf(100))
                .build();

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/calc-feel")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(rentabilityDTO))).andReturn();

        RentabilityDTO rentabilityResponse = gson.fromJson(mvcResult.getResponse().getContentAsString(), RentabilityDTO.class);

        Assertions.assertEquals(103.01761094110888, rentabilityResponse.getOutputValue());
        Assertions.assertEquals(180, rentabilityResponse.getDays());
        Assertions.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("Test To Calc Rentability By Controller With Failed")
    public void testToCalcRentabilityByControllerWithFailed() throws Exception {

        Gson gson = new Gson();

        RentabilityDTO rentabilityDTO = RentabilityDTO.builder().feel(BigDecimal.valueOf(4.25))
                .weeks(0)
                .inputValue(BigDecimal.valueOf(100))
                .build();

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/calc-feel")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .content(gson.toJson(rentabilityDTO))).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
