package com.in.serviceClass;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.entity.Product;
import com.in.repository.ProductRepository;
import com.in.serviceInterfaace.ProductInterface;

@Service
public class ProductServiceClass implements ProductInterface {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveData(Product p) {
		
		productRepository.save(p);
		
		
	}

	@Override
	public List<Product> get() {
	
		return productRepository.findAll();
	}

	@Override
	public List<Product> delete(Integer pid) {
		productRepository.deleteById(pid);
		
		return productRepository.findAll();
	}

	@Override
	public Product update(Product p) {
		
		
		Optional<Product> byId = productRepository.findById(p.getPid());
		
		if(byId.isPresent())
		{
			Product updateproduct = byId.get();
			
			updateproduct.setPname(p.getPname());
			updateproduct.setPprice(p.getPprice());
			updateproduct.setPdetails(p.getPdetails());
			updateproduct.setPcategory(p.getPcategory());
			
			return productRepository.save(updateproduct);
		}
		else {
			return productRepository.save(p);
		}
		
//		1st Logic
		
//		Product product = productRepository.findById(pid).get();
//		product.setPname(p.getPname());
//		product.setPcategory(p.getPcategory());
//		product.setPdetails(p.getPdetails());
//		product.setPprice(p.getPprice());
//		return productRepository.save(p);
		
		
//		2nd logic
		
//		if(!product.getPid().isPresent())
//		{
//			productRepository.save(p);
//		}
//		else {
//			product.setPname(p.getPname());
//			product.setPcategory(p.getPcategory());
//			product.setPdetails(p.getPdetails());
//			product.setPprice(p.getPprice());
//			
//			return productRepository.save(p);
//		}
//		
		
		
		
		
		
//		return null;
	}

	@Override
	public Optional<Product> getbypid(Integer pid) {
		
		return productRepository.findById(pid);
	}

	@Override
	public Product updateR(Integer pid, Product p) {
		
		         Optional<Product> product = productRepository.findById(pid);
		         
		         if(product.isPresent())
		         {
		        	 Product productUpdate = product.get();
		        	 
		        	 productUpdate.setPname(p.getPname());
		        	 productUpdate.setPprice(p.getPprice());
		        	 productUpdate.setPdetails(p.getPdetails());
		        	 productUpdate.setPcategory(p.getPcategory());

		        	 return productRepository.save(productUpdate);
		        	 
		         }
		         else {
		        	 throw new RuntimeException("Product Not Fount "+pid);
		         }
	
		
	}

}
