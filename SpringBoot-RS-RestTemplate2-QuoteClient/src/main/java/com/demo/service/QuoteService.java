package com.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.model.QuoteResponse;
import com.demo.props.AppProperties;

@Service
public class QuoteService {
	
	@Autowired
	private AppProperties appProperties;

	public String invokeQuoteApi() {
		RestTemplate restTemplate = new RestTemplate();

		// String apiUrl = "https://quoters.apps.pcfone.io/api/random";
		Map<String, String> message = appProperties.getMessages();
		String apiUrl = message.get("apiurl");

		ResponseEntity<QuoteResponse> responseEntity = restTemplate.getForEntity(apiUrl, QuoteResponse.class);

		int statusCode = responseEntity.getStatusCodeValue();

		if (statusCode == 200) {
			QuoteResponse response = responseEntity.getBody();
			return response.getValue().getQuote().toUpperCase();
		}
		return null;
	}

}
