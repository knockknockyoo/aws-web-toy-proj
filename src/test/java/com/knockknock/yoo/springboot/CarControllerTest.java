package com.knockknock.yoo.springboot;


import com.knockknock.yoo.springboot.CarController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCarBrand_Test() throws Exception {

        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("brand", "bmw");

        mockMvc.perform(get("/brand")
                .params(info))
                .andExpect(status().isOk())
                .andExpect(content().string("bmw"))
                .andDo(print());
    }

    @Test
    public void getCarResponseDto_test() throws Exception {

        String name = "car";
        int amount = 1000;

        mockMvc.perform(get("/brand/dto")
                        .param("name", name)
                        // Parameter needs to be converted to String
                        .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    // Search a field by $ indicator
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));

    }



}