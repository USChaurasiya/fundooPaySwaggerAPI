package com.bridgelabz.fundooPay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(hidden = true)
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}

}
