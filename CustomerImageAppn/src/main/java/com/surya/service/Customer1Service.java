package com.surya.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.surya.model.Customer1;



public interface Customer1Service {
public Customer1 saveStudent(MultipartFile file,Integer cid, String cname, String prodName, Integer qty,Integer price);
public Customer1 getOne(Integer cid,String cname);
public List<Customer1> getAllCustomers();
public void deleteCustomer(Integer cid);
public void updateCustomer(MultipartFile file,Integer cid, String cname, String productName, Integer qty,Integer price);

	
	

}
