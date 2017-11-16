package com.bridgelabz.fundooPay.service.utilservice;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundooPay.bean.ServiceProvider;

@Component
public class MessageService {

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	public  void confirmRegistration(ServiceProvider serviceProvider) {

		final String token = UUID.randomUUID().toString();
		final SimpleMailMessage email = constructEmailMessage(serviceProvider, token);
		System.out.println("Send Email" + email);
		mailSender.send(email);
	}


	private final SimpleMailMessage constructEmailMessage(final ServiceProvider serviceProvider, final String token) {
		final String recipientAddress = serviceProvider.getSpMail();
		System.out.println("user mail:" + recipientAddress);
		System.out.println(token);
		final String subject = "FundooPay Registration Confirmation";
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("Hi "  + serviceProvider.getSpName()+ " \r\n"+"Welcome to FundooPay and Thanks for registration."+ " \r\n"+"Your Access Token is:"+token);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}
}
