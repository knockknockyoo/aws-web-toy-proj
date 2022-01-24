package com.knockknock.yoo.springboot.web.dto;

public class CarResponseDto {

    private final String name;
    private final int amount;

    public CarResponseDto(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
