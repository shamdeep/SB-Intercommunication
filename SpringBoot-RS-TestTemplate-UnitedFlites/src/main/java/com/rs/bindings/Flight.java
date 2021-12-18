package com.rs.bindings;

import lombok.Data;

@Data
public class Flight {

	private String code;
	private Integer price;
	private String origin;
	private String destinatio;
	private String departureDate;
	private String planeType;
	private String airlineName;
	private Integer emptySeats;
}
