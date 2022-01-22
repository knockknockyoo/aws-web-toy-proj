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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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



}