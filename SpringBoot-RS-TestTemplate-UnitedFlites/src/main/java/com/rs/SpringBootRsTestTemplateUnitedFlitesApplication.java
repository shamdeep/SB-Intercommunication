package com.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.rs.service.FlightService;

@SpringBootApplication
public class SpringBootRsTestTemplateUnitedFlitesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication
				.run(SpringBootRsTestTemplateUnitedFlitesApplication.class, args);

		/*FlightService flightService = ctx.getBean(FlightService.class);
		flightService.invokeFlightServiceApi();*/

	}

}
