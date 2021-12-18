package com.wc.controller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wc.model.CustomerEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class CustomerController {

	// It will produce single response only using mono Object
	@GetMapping(value = "/getEvent", produces = "application/json")
	public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent() {
		CustomerEvent event = new CustomerEvent("john", new Date());

		Mono<CustomerEvent> customerMono = Mono.just(event);

		ResponseEntity<Mono<CustomerEvent>> responseEntity = new ResponseEntity<Mono<CustomerEvent>>(customerMono,
				HttpStatus.OK);

		return responseEntity;

	}

	@GetMapping(value = "/getEvents", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents() {
		// Creating Pojo object with customer event data
		CustomerEvent customerEvent = new CustomerEvent("Smith", new Date());

		// Creating stream object to send the data
		Stream<CustomerEvent> customerStream = Stream.generate(() -> customerEvent);

		// Giving Stream object to flux object
		Flux<CustomerEvent> ceFlux = Flux.fromStream(customerStream);

		// setting response interval
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

		// combining intervalFlux and CustomerEventFlux
		Flux<Tuple2<Long, CustomerEvent>> zip = Flux.zip(interval, ceFlux);

		// Getting second tupple value as Flux obj
		Flux<CustomerEvent> fluxMap = zip.map(Tuple2::getT2);

		// Adding flux object to response Body
		ResponseEntity<Flux<CustomerEvent>> responseEntity = new ResponseEntity<Flux<CustomerEvent>>(fluxMap,
				HttpStatus.OK);

		
		//Returning resEntity to flux object
		return responseEntity;

	}
}
