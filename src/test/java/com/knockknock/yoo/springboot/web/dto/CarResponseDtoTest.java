package com.knockknock.yoo.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarResponseDtoTest {

    @Test
    public void responseDto_Test() {

        String name = "car";
        int amount = 1000;

        CarResponseDto dto = new CarResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }

}