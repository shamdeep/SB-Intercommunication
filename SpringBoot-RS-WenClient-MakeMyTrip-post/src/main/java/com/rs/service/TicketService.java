package com.rs.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.rs.request.PassengerRequest;
import com.rs.response.TicketResponse;

@Service
public class TicketService {

	public TicketResponse initiateTicketBookingProcess(PassengerRequest passengerRequest) {
		String apiendpointUrl = "http://localhost:8080/bookticket";

		WebClient webClient = WebClient.create();
		 TicketResponse  ticketResponse =  webClient.post()
										.uri(apiendpointUrl)
										.contentType(MediaType.APPLICATION_JSON)
										// Need to send the body to the client
										.body(passengerRequest,PassengerRequest.class)
										.retrieve()
										.bodyToMono(TicketResponse.class)
										.block();

		return ticketResponse;
	}
	
	
}
