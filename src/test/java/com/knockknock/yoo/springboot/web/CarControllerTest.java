package com.knockknock.yoo.springboot.web;
import com.knockknock.yoo.springboot.CarController;
import com.knockknock.yoo.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CarController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        })
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Test
    @WithMockUser(roles="USER")
    public void getCarBrand_Test() throws Exception {

        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("brand", "bmw");

        mvc.perform(get("/brand")
                .params(info))
                .andExpect(status().isOk())
                .andExpect(content().string("bmw"))
                .andDo(print());
    }

    @Test
    @WithMockUser(roles="USER")
    public void getCarResponseDto_test() throws Exception {

        String name = "car";
        int amount = 1000;

        mvc.perform(get("/brand/dto")
                        .param("name", name)
                        // Parameter needs to be converted to String
                        .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    // Search a field by $ indicator
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));

    }



}