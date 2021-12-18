package com.wc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class QuoteService {

	public String invokeQuoteApi() {
		String endpointUrl = "https://quoters.apps.pcfone.io/api/random";

		WebClient webClient = WebClient.create();
		
		           webClient.get()
		                        .uri(endpointUrl)
		                        .retrieve()
		                        .bodyToMono(String.class)
		                        .subscribe(QuoteService::handleResponse);
		           
		           System.out.println("****Request Sent****");
		           
		return "Success";
	}
	
	public static void handleResponse(String resData)
	{
		System.out.println(resData);
		System.out.println(" Response pushed to Apache Kafka");
	}
}
