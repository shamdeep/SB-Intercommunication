package com.rs.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.bindings.Flight;
import com.rs.bindings.Flights;

@Service
public class FlightService {

	public String invokeFlightServiceApi() {

		String endPointUrl = "http://mu.mulesoft-training.com/essentials/united/flights";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointUrl, String.class);

		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			String body = responseEntity.getBody();
			System.out.println(body);
			return body;
		}
		return null;

	}

	public Flights invokeFlightsApi() {

		String endPointUrl = "http://mu.mulesoft-training.com/essentials/united/flights";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Flights> responseEntity = restTemplate.getForEntity(endPointUrl, Flights.class);

		Flights body = responseEntity.getBody();

		//<Flight> list = body.getFlights();

		/*list.forEach(flight -> {
			System.out.println(flight);
		});*/
        return body;
	}

}
