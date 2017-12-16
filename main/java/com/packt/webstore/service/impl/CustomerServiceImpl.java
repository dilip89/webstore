package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private List <Customer> customerList = new ArrayList<Customer>();
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		
		customerList = customerRepository.getAllCustomers();
		System.out.println("Customer Service calling persistance layer method ");
		
		return customerList;
	}
	
	
}
