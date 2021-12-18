package com.rs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.request.PassengerRequest;
import com.rs.response.TicketResponse;

@Service
public class TicketService {

	@Autowired
	RestTemplate restTemplate;

	public TicketResponse initiateTicketBookingProcess(PassengerRequest passengerRequest) {
		String apiendpointUrl = "http://localhost:8080/bookticket";

		// RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<TicketResponse> responseEntity = restTemplate.postForEntity(apiendpointUrl, passengerRequest,
				TicketResponse.class);

		TicketResponse response = responseEntity.getBody();
		return response;
	}
}
