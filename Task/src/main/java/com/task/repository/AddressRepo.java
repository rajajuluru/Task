package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Address1;

public interface AddressRepo extends JpaRepository<Address1, Integer> {
	
	
	//Address findByAddressIdAndEmpempid(Integer aid,Integer empid);

}
