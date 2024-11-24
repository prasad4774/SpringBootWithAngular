package com.in.serviceInterfaace;

import java.util.List;
import java.util.Optional;

import com.in.entity.Product;

public interface ProductInterface {

	
	public void saveData(Product p);
	
	public List<Product> get();
	public List<Product> delete(Integer pid);
	
	public Product update(Product p);
	
	public Optional<Product> getbypid(Integer pid);
	
	public Product updateR(Integer pid, Product p);
}
