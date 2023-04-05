package com.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.surya.model.Customer1;
import com.surya.service.Customer1ServiceImp;

@RestController
@CrossOrigin("*")
public class Customer1Controller {
	@Autowired
    private Customer1ServiceImp service;
	
	@PostMapping("/save")
	public String saveImage(@RequestParam MultipartFile file,@RequestParam Integer cid,
			                @RequestParam String cname,@RequestParam String productName,@RequestParam Integer qty,
			                @RequestParam Integer price) {
	
	   Customer1 c1=service.saveStudent(file, cid, cname, productName, qty, price);
	   String mes=null;
	   if(c1!=null)
	   {
		   mes="image is uploaded successfully";
	   }
	   else
	   {
		   mes="uploda image failed";
	   }
	   return mes;
	
		
	}
	   @GetMapping("/getOne/{cid}/{cname}")
	    public Customer1 getCust(@PathVariable Integer cid,@PathVariable String cname)
	    {
	    	Customer1 c2=service.getOne(cid,cname);
	    	return c2;
	    }
	@GetMapping("/getAll")
	public List<Customer1> getAll()
	{
		List<Customer1> c2=service.getAllCustomers();
		return c2;	
	}
	@DeleteMapping("/delete/{cid}")
    public void deleteCust(@PathVariable Integer cid)
    {
    	
    	service.deleteCustomer(cid);
    }
	@PutMapping("/update/{cid}")
    public String updateCustomer(@PathVariable Integer cid,
                                                 @RequestParam MultipartFile file,
                                                 @RequestParam String cname,
                                                 @RequestParam String productName,
                                                 @RequestParam Integer qty,
                                                 @RequestParam Integer price) {
        service.updateCustomer(file,cid ,cname,productName,qty,price);
       return "success";

}
}
