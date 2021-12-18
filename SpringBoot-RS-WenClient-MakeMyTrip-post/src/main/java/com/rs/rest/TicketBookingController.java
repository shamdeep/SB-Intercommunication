package com.rs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rs.request.PassengerRequest;
import com.rs.response.TicketResponse;
import com.rs.service.TicketService;

@RestController
public class TicketBookingController {

	@Autowired
	private TicketService service;

	@PostMapping(value = "/book")
	public TicketResponse bookTicket(@RequestBody PassengerRequest passengerRequest) {
		return service.initiateTicketBookingProcess(passengerRequest);
	}
}
