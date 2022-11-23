package com.dev.customer.snct.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.dev.customer.snct.entity.Customer;

public class CustomerMapper implements FieldSetMapper<Customer>{

	@Override
	public Customer mapFieldSet(FieldSet fieldSet) throws BindException {
		Customer customer = new Customer();
		customer.setFullName(fieldSet.readString(0));
		customer.setDocumentNumber(fieldSet.readString(1));
		return customer;
	}

}
