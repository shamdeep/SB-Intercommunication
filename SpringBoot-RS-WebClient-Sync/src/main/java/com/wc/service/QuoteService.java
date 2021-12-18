package com.wc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QuoteService {

	public String invokeQuoteApi() {
		String endpointUrl = "https://quoters.apps.pcfone.io/api/random";

		WebClient webClient = WebClient.create();
		
		          String block = webClient.get()
		                        .uri(endpointUrl).
		                        retrieve().
		                        bodyToMono(String.class).
		                        block();

		return block;
	}
}
