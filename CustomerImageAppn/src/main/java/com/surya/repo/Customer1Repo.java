package com.surya.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surya.model.Customer1;
@Repository
public interface Customer1Repo extends JpaRepository<Customer1, Integer> {

}
