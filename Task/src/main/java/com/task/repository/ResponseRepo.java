package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.Employee1;

@Repository
public interface ResponseRepo extends JpaRepository<Employee1, Integer> {
	
	
	/*
	 * @Query(value="select a,b from Employee a,Address b where a.empid=b.empempid")
	 * public List<Object[]> getAlldata();
	 */
}
