package com.dev.customer.snct.processors;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dev.customer.snct.entity.Customer;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer>{

	@Override
	public Customer process(final Customer customer) throws Exception {
		final var dateTime = LocalDateTime.now();
		customer.setDateTime(dateTime);
		return customer;
	}

}
