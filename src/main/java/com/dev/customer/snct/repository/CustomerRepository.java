package com.dev.customer.snct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.customer.snct.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
