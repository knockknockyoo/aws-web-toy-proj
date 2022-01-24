package com.knockknock.yoo.springboot;

import com.knockknock.yoo.springboot.web.dto.CarResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/brand")
    public String getCarBrand(@RequestParam String brand){
        return brand;
    }

    @GetMapping("/brand/dto")
    public CarResponseDto getResponseDto (@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new CarResponseDto(name, amount);
    }

}
