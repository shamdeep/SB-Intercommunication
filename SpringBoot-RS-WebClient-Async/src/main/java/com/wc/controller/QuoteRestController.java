package com.wc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wc.service.QuoteService;

@RestController
public class QuoteRestController {

	@Autowired
	private QuoteService quoteService;

	@GetMapping(value = "/random")
	public String getRandomQuote() {
		String response = quoteService.invokeQuoteApi();
		return response;
	}
}
