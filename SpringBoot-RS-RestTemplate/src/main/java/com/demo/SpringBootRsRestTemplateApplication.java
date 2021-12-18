package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.service.QuoteService;

@SpringBootApplication
public class SpringBootRsRestTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootRsRestTemplateApplication.class, args);
		QuoteService quoteService = ctx.getBean(QuoteService.class);
		quoteService.invokeQuoteApi();
	}

}
