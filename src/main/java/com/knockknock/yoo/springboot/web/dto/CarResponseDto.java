package com.knockknock.yoo.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CarResponseDto {

    private final String name;
    private final int amount;
}
