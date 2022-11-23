package com.dev.customer.snct.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dev.customer.snct.entity.Customer;
import com.dev.customer.snct.repository.CustomerRepository;

@Component
public class CustomerWriter implements ItemWriter<Customer>{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void write(List<? extends Customer> list) throws Exception {
		customerRepository.saveAll(list);
		
		final var customers = customerRepository.findAll();
		
		System.out.println("============================================");
		
		customers.forEach(customer -> {
			System.out.println(customer.toString());
		});
	}

}
