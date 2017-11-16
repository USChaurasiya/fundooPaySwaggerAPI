package com.bridgelabz.fundooPay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiModelProperty;
@Controller

public class HomeController {

	@RequestMapping("/")
	@ApiModelProperty(hidden = true)
    public String home() {
        return "redirect:swagger-ui.html";
    }
	
}
