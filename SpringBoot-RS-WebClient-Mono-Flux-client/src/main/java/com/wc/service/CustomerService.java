package com.wc.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientRequest.Builder;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class CustomerService {
	
	// This is representing mono object response
    String endpointUrl1 = "https://localhost:9090/getEvent";

	// This is representing flux object response
	String endpointUrl2 = "https://localhost:9090/getEvents";

	public void invokeCusterEvent() {

		org.springframework.web.reactive.function.client.WebClient.Builder builder =  WebClient.builder();
		WebClient webClient = builder.build();
		
		String response = webClient.get()
									.uri(endpointUrl1)
									.retrieve().bodyToMono(String.class)
									.block();

		System.out.println(response);

	}
	
	public void invokeCustomerEvents()
	{
		org.springframework.web.reactive.function.client.WebClient.Builder builder =  WebClient.builder();
		WebClient webClient = builder.build();
		
		webClient.get()
				.uri(endpointUrl2)
				.retrieve()
				.bodyToFlux(String.class)
				.subscribe(System.out::println);
		
	}
}
