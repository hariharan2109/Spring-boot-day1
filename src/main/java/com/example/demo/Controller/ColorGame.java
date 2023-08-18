package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorGame {
//	@Value("${color}")
	private String color="green";
	
    @GetMapping("/color")
    public String getColor()
    {
  	   return "My favourite color is "+color;
    }
}
