package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
	private List <Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product ("P1234", "iPhone 6s", new BigDecimal(500));
		iphone.setDescription("Apple 6s with ATT contract");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product ("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 13 inch 2-1");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product ("P1236", "Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 with 15Mpx camera");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}

	public List<Product> getAllProducts(){
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productByID = null;
		for(Product product: listOfProducts) {
			System.out.println("Product "+ product.getName());
			if(product!= null && product.getProductId()!= null && product.getProductId().equals(productId)) {
				productByID=product;
				System.out.println(productByID +" product added");
				break;
			}
		}
		if(productByID == null) {
			throw new IllegalArgumentException("No product found with product ID: "+ productId);
		}
	return productByID;
	}
	
	public List<Product> getProductByCategory(String category){
		List<Product> productByCategory = new ArrayList<Product>();
		for(Product product: listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())) {
				productByCategory.add(product);
			}
		}
		return productByCategory;
	}
	
	public Set<Product> getProductsByFilter(Map <String, List<String>> filterParams){
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		
		Set<String> criterias = filterParams.keySet();
		
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {        
				for(Product product: listOfProducts) {          
					if(brandName.equalsIgnoreCase(product.getManufacturer())){            
						productsByBrand.add(product);          
					}       
				 }      
			}    
			}        
		if(criterias.contains("category")) {      
			for(String category: filterParams.get("category")) {        
				productsByCategory.addAll(this.getProductByCategory(category));
			 }    
		}        
		productsByCategory.retainAll(productsByBrand);        
		
		return productsByCategory; 
	} 
}
