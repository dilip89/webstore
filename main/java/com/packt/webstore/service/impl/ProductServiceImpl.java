package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private List <Product> listOfProducts = new ArrayList<Product>();
	@Autowired
	private ProductRepository productRepository;
	
	public List <Product> getAllProducts(){
		listOfProducts = productRepository.getAllProducts();
		System.out.println("Coming in service impl");
		return listOfProducts;
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(String category){
		return productRepository.getProductByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

}
