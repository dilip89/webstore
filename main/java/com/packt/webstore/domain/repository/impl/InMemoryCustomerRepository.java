package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	
	private List <Customer> listOfCustomers = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
	
		Customer cust1 = new Customer("C1234", "Dexter", "1825 Reindeer Pl Bear DE");
		cust1.setNoOfOrdersMade(2);
		
		Customer cust2 = new Customer("C1235", "Anu", "8125 48 Ave College Park");
		cust2.setNoOfOrdersMade(4);
		
		listOfCustomers.add(cust1);
		listOfCustomers.add(cust2);
		
	}

	public List<Customer> getAllCustomers() {
	
		return listOfCustomers;
	}
	
	
	

}
