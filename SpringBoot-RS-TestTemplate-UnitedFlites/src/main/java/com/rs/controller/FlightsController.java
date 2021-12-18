package com.rs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.bindings.Flights;
import com.rs.service.FlightService;

@RestController
public class FlightsController {

	@Autowired
	FlightService flightService;

	@GetMapping(value = "/flights")
	public String getFlights() {
		return flightService.invokeFlightServiceApi();
	}

	/*@GetMapping(value = "/flightsInfo")
	public String getFlightsInfo() {
		flightService.invokeFlightsApi();
		return "Success";
	}*/
	
	@GetMapping(value = "/flightsInfo")
	public Flights getFlightsInfo() {
		Flights flights = flightService.invokeFlightsApi();
		return flights;
	}
}
