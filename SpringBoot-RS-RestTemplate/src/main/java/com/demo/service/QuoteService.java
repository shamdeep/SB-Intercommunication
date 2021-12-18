package com.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

	public void invokeQuoteApi() {
		RestTemplate restTemplate = new RestTemplate();

		String apiUrl = "https://quoters.apps.pcfone.io/api/random";

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

		int statusCode = responseEntity.getStatusCodeValue();

		if (statusCode == 200) {
			String body = responseEntity.getBody();
			System.out.println(body);
		}
	}
}
