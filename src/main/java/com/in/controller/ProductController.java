package com.in.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.entity.Product;
import com.in.serviceClass.ProductServiceClass;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

   @Autowired
   private ProductServiceClass serviceClass;
	
   @GetMapping("/")
   public ResponseEntity test()
   {
	   return new ResponseEntity<>("Test App",HttpStatus.OK);
   }
   
   @PostMapping("/save")
   public ResponseEntity save(@RequestBody Product p)
   {
	   serviceClass.saveData(p);
	   
	   return new ResponseEntity<>(HttpStatus.CREATED);
   }
	
   @GetMapping("/get")
   public ResponseEntity<List<Product>> getproduct()
   {
	   List<Product> list = serviceClass.get();
	   
	   return  new ResponseEntity<List<Product>>(list ,HttpStatus.OK);
   }
   
   @DeleteMapping("/delete/{pid}")
   public ResponseEntity<List<Product>> delete(@PathVariable ("pid") Integer pid )
   {
	   List<Product> list = serviceClass.delete(pid);
	   return  new ResponseEntity<List<Product>>(list ,HttpStatus.FOUND);   
   }
   
//   @PutMapping("/update")
//   public ResponseEntity update( @RequestBody Product p  )
//   {
//	   serviceClass.update(p);
//	   
//	   return new ResponseEntity<>("Product Updated",HttpStatus.OK);
//	  
//   }
   
   @GetMapping("getbypid/{pid}")
   public ResponseEntity<Optional<Product>> getuser(@PathVariable("pid") Integer pid)
   {
	   
	   Optional<Product> getbypid = serviceClass.getbypid(pid);
	   
	   return new ResponseEntity<Optional<Product>>(getbypid,HttpStatus.OK);
   }
   
//   real time Example of Update logic
   
   
   @PutMapping("updateR/{pid}")
   public ResponseEntity<Product> updateR(@PathVariable("pid") Integer pid, @RequestBody Product p)
   {
	   
	   Product updateR = serviceClass.updateR(pid, p);
	   
	   return new ResponseEntity<Product>(updateR,HttpStatus.NOT_FOUND);
   }
   
   
   
}
