package com.dev.customer.snct.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dev.customer.snct.entity.Customer;
import com.dev.customer.snct.processors.CustomerProcessor;
import com.dev.customer.snct.reader.CustomerReader;
import com.dev.customer.snct.writer.CustomerWriter;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job costumerJob(final Step customerStep) {

		return jobBuilderFactory.get("costumerJob")
				.start(customerStep)
				.build();

	}

	@Bean
	public Step costumerStep(CustomerReader customerReader, CustomerProcessor customerProcessor, CustomerWriter customerWriter) {
		
		return stepBuilderFactory
				.get("costumerStep")
				.<Customer, Customer>chunk(1)
				.reader(customerReader)
				.processor(customerProcessor)
				.writer(customerWriter)
				.build();
	}
}
