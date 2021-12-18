package com.file.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.file.config.AppConfig;

@RestController
public class WelcomeRestController {

	@Autowired
	private AppConfig appConfig;

	//http://localhost:9090/welcome
	@GetMapping(value = "/welcome")
	public String welcomeMessage() {
		Map<String, String> msg = appConfig.getMessages();
		String messageVal = msg.get("WelcomeMsg");
		return messageVal;
	}

	//http://localhost:9090/greetMessage
	@GetMapping(value = "/greetMessage")
	public String greetMessage() {
		Map<String, String> msg = appConfig.getMessages();
		String greetMsg = msg.get("greetMsg");
		return greetMsg;
	}

}
