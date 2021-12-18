package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.service.QuoteService;

@SpringBootApplication
public class SpringBootRsRestTemplate2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootRsRestTemplate2Application.class, args);
		QuoteService quoteService = ctx.getBean(QuoteService.class);
		String result = quoteService.invokeQuoteApi();
		System.out.println(result);
	}

}
