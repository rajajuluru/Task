package com.task.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.task.controller.Service.DaoService;
import com.task.controller.Service.IdGeneration;
import com.task.model.Address1;
import com.task.model.Address2;
import com.task.model.Employee1;
import com.task.model.RequestHelperClass;
import com.task.repository.AddressRepo;
import com.task.repository.ResponseRepo;

import javassist.bytecode.Mnemonic;

@RestController

public class InitialController {
	@Autowired
	DaoService DaoService;
	@Autowired
	AddressRepo AddressRepo;
	@Autowired
	ResponseRepo ResponseRepo;
	@Autowired
	IdGeneration IdGeneration;

	@Autowired
	EntityManager manager;
	

@GetMapping("getAllEmployees")
public String getAllEmployees()
{
	return new Gson().toJson(DaoService.getEmployees().toString());
}
	

@PostMapping("updateaddress/{empid}/{addressId}")
public String updateaddress(@PathVariable("empid") Integer empid,@PathVariable("addressId") Integer addressId,@RequestBody RequestHelperClass helper)
{
	System.out.println(helper+"helper");
	try
	{
		return DaoService.updateaddress(empid, addressId, helper);
	}
	catch (Exception e) {
		// TODO: handle exception
		return e.getMessage();
	}
}
	
	


	
	@PostMapping(value = "insert")
	public String insert(@RequestBody RequestHelperClass helper) throws JsonProcessingException
	{
		Session unwrap = manager.unwrap(Session.class);
		unwrap.beginTransaction();		


Employee1 emp = new Employee1();
emp.setEmail(helper.getEmail());
emp.setEmployeeId(helper.getEmployeeId());
emp.setEmployeeName(helper.getName());
//emp.setAddresses(helper.getAddress());
System.out.println(helper);

List<Address1> addresslist=new ArrayList<>();
		  List<Address2> address = helper.getAddress();
		  for(Address2 r:address) {
			  
			
			  Address1 ad1=new Address1();
			  ad1.setAddressline(r.getAddressline());
			  ad1.setCity(r.getCity());
			  ad1.setCountry(r.getCountry());
			  ad1.setState(r.getState());
			  ad1.setPincode(r.getPincode());
			  System.out.println(ad1+"  System.out.println();");
			  addresslist.add(ad1);
			  emp.getAddressList().add(ad1);
		  
		  //r.setEmp_emp_id(IdGeneration.empidgeneration());
		  
		  }
		  
		  System.out.println(emp.getAddressList().size()+"emp size");
		  //emp.setAddressList(addresslist);
		 
	



unwrap.save(emp);
unwrap.getTransaction().commit();
Query createQuery = unwrap.createQuery("from Employee1",Employee1.class);
	
System.out.println(createQuery.getResultList().size()+"createQuery.getResultList()");
		
List<Employee1> resultList = createQuery.getResultList();
String json = new Gson().toJson(resultList );
return json;
	}
	
	

@PostMapping("modifyuser/{id}")//working
public ResponseEntity<Object> modifyUser(@PathVariable("id") Integer id,@RequestBody RequestHelperClass helper)
{
	System.out.println("hdhjsghjhdfjghhdjfhj");
	
	Session unwrap = manager.unwrap(Session.class);
	

		Employee1 emp = new Employee1();
		emp.setEmail(helper.getEmail());
		//emp.setEmployeeId(helper.getEmployeeId());
		emp.setEmployeeName(helper.getName());
		//ResponseRepo.save(emp);
		
		//updatege
		Employee1 emp1=new Employee1();
		 Employee1 find = unwrap.find(Employee1.class, id);
		 Optional<Employee1> ofNullable = Optional.ofNullable(find);
	if(ofNullable.isPresent())
	{unwrap.beginTransaction();		
		 find.setEmail(emp.getEmail());
			// find.setEmployeeId(id);
			 find.setEmployeeName(emp.getEmployeeName());
			 unwrap.saveOrUpdate(find);
			 unwrap.getTransaction().commit();
			 System.out.println("hdhjsghjhdfjghhdjfhj1");
			 Employee1 find2 = unwrap.find(Employee1.class, id);
			 emp1=find2;
	return new ResponseEntity<>("Successfully updted the user detils",HttpStatus.OK);
		
		
	}
	else
	{
		System.out.println("hdhjsghjhdfjghhdjfhj3");
		return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
	}
	
	
}



@DeleteMapping("deleteuser/{id}")
public ResponseEntity<Object> delete(@PathVariable("id") Integer id)
{
	System.out.println("hdhjsghjhdfjghhdjfhj"+id);
	
	Session unwrap = manager.unwrap(Session.class);
	 Employee1 find = unwrap.find(Employee1.class, id);
	 unwrap.beginTransaction();	
		unwrap.delete(find);
		
		unwrap.getTransaction().commit();
	return new ResponseEntity<>("Successfully updted the user detils",HttpStatus.OK);
		
		
	}
	

}
