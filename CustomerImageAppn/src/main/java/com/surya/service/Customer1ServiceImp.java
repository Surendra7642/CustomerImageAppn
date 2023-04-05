package com.surya.service;

import java.io.IOException;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.surya.model.Customer1;
import com.surya.repo.Customer1Repo;
@Service
public class Customer1ServiceImp implements Customer1Service {
	@Autowired
	private Customer1Repo repo;

	@Override
	public Customer1 saveStudent(MultipartFile file, Integer cid, String cname, String productName, Integer qty,
			Integer price) {
		Customer1 cust =new Customer1();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			cust.setProdImage(Base64.getEncoder().encodeToString(file.getBytes()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		cust.setCid(cid);
		cust.setCname(cname);
		cust.setProductName(productName);
		cust.setQty(qty);
//		if(qty*price>20000) {
//			cust.setPrice((int) Math.round(price-0.25*price));
//		}
		//cust.setPrice((qty * price > 10000) ? (int) Math.round(price - 0.15 * price) : (qty * price > 5000) ? (int) Math.round(price - 0.10 * price) : (int) Math.round(price));

//		cust.setPrice(price);
		
		//price -> only one item price
		//total -> quantity*price
		//discount
		//bill->final amount
		
		cust.setPrice(price);
		cust.setTotal(qty*price);
		cust.setDiscount((cust.getTotal() > 10000) ? (int) Math.round(price - 0.15 * price) : (cust.getTotal() > 5000) ? (int) Math.round(price - 0.10 * price):(cust.getTotal() > 25000) ? (int) Math.round(price - 0.25 * price) : (int) Math.round(price));
		cust.setBill((cust.getTotal() > 10000) ? cust.getTotal()-(int) Math.round(price - 0.15 * price) : (cust.getTotal() > 5000) ? cust.getTotal()-(int) Math.round(price - 0.10 * price):(cust.getTotal() > 25000) ? cust.getTotal()-(int) Math.round(price - 0.25 * price) : (int) Math.round(price));
		Customer1 cust1=repo.save(cust);
		return cust1;
	}
	public Customer1 getOne(Integer cid,String cname) {
		Customer1 cust2 = repo.findById(cid).get();
		return cust2;
	}

	@Override
	public List<Customer1> getAllCustomers() {
		List<Customer1> cust2=repo.findAll();
		return cust2;
	}
	public void deleteCustomer(Integer cid) {
    	repo.deleteById(cid);
    
}
	public void updateCustomer(MultipartFile file,Integer cid, String cname, String productName, Integer qty,Integer price)
	{
		  Optional<Customer1> optionalCustomer1 = repo.findById(cid);
		    if (optionalCustomer1.isPresent()) {
		        Customer1 customer = optionalCustomer1.get();
		        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		        if(fileName.contains(".."))
		        {
		            System.out.println("not a valid file");
		        }
		        try {
		        	customer.setProdImage(Base64.getEncoder().encodeToString(file.getBytes()));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        customer.setCname(cname);
		        customer.setProductName(productName);
		        customer.setQty(qty);
		        customer.setPrice(price);
		        repo.save(customer);
		    } 
//		    else {
//		        System.out.println("Customer not found");
//		    }

	}
	
}
