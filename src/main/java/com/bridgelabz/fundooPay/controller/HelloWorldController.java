package com.bridgelabz.fundooPay.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgelabz.fundooPay.bean.ServiceProvider;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

public class HelloWorldController {
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Display greeting message to non-admin user", response = ServiceProvider.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public ServiceProvider message(@PathVariable ServiceProvider  name) {
        ServiceProvider serviceProvider  = new ServiceProvider();
        return serviceProvider;
    }
}
