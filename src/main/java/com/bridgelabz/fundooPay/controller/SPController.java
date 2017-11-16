package com.bridgelabz.fundooPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import com.bridgelabz.fundooPay.bean.Location;
import com.bridgelabz.fundooPay.bean.ServiceProvider;
import com.bridgelabz.fundooPay.bean.*;
import com.bridgelabz.fundooPay.persistence.ServiceProviderDAO;
import com.bridgelabz.fundooPay.service.utilservice.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
/* @RequestMapping("/serviceprovider") */
@Api(value = "admin", description = "Rest API for Service Provider", tags = "Service Provider API")
public class SPController {

	@Autowired
	ServiceProviderDAO serviceProviderDAO;

	@Autowired
	JavaMailSender mailSender;
	@Autowired
	MessageService msgService;

	/*--------------------------------SERVICE PROVIDER REGISTRATION------------------------------------------*/
	@RequestMapping(value = "/register/{serviceType}", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Register New Service Provider", response = ServiceProvider.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Service provider Registered Successfully"),
			@ApiResponse(code = 401, message = "You are not authorized access the resource"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<ServiceProvider> registerServiceProvider(@PathVariable ServiceType serviceType,
			@RequestBody ServiceProvider serviceProvider) {

		System.out.println(serviceProvider);
		System.out.println(serviceType);
		String type = serviceType.toString();
		serviceProvider.setServiceType(type);
		ServiceProvider serviceProvider2 = serviceProviderDAO.save(serviceProvider);
		msgService.confirmRegistration(serviceProvider2);

		return new ResponseEntity<ServiceProvider>(serviceProvider2, HttpStatus.OK);
	}

	/*--------------------------------FIND SERVICE PROVIDER BY ID------------------------------------------*/
	@RequestMapping(value = "/getserviceprovider/{spId}", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Service Provider  By SP Id", response = ServiceProvider.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "You are not authorized access the resource"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public @ResponseBody ServiceProvider getServiceProvider(@PathVariable Long spId) {

		ServiceProvider sp = serviceProviderDAO.findServiceProviderById(spId);

		return sp;
	}

	/*--------------------------------OTP VERIFICATION------------------------------------------*/
	@RequestMapping(value = "/verifyotp", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Verify User Mobile Number by OTP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OTP Verified Successfully.."),
			@ApiResponse(code = 401, message = "You are not authorized access the resource"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public ResponseEntity<Boolean> verifyOTP(@RequestParam("token") final String token) {

		System.out.println(token);
		if (token.equals("1234")) {
			return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_ACCEPTABLE);
	}

	/*--------------------------------FIND SERVICE PROVIDER BY ID------------------------------------------*/
	@RequestMapping(value = "/setlocation", method = RequestMethod.POST, produces = "application/json")
	@ApiOperation(value = "Get Service Provider  By SP Id", response = Location.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "You are not authorized access the resource"),
			@ApiResponse(code = 404, message = "The resource not found") })
	public @ResponseBody Location get(@RequestBody Location location) {

		System.out.println("lat:" + location.getLatitude());
		System.out.println("long:" + location.getLongitude());

		return location;
	}

}
