package com.knockknock.yoo.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/brand")
    public String getCarBrand(@RequestParam String brand){
        return brand;
    }
}
