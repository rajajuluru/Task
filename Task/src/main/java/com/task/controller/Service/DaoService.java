package com.task.controller.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.google.gson.Gson;
import com.task.model.Address1;
import com.task.model.Employee1;
import com.task.model.RequestHelperClass;
@RequestScope
@Service
public class DaoService {
	
	@Autowired
	EntityManagerFactory fc;
	@SuppressWarnings("unchecked")
	public List<Employee1> getEmployees()
	{
		EntityManager manager=fc.createEntityManager();
		List<Employee1> resultList=null;
		manager.getTransaction().begin();
		Query createQuery = manager.createQuery("from Employee1");
		//createQuery.setLockMode(LockModeType.PESSIMISTIC_WRITE);
		 resultList = createQuery.getResultList();
	System.out.println(resultList.size()+"resultList.size()");
	manager.close();
	return resultList;
	}
	
	@SuppressWarnings("unchecked")
	public String updateaddress(Integer empid,Integer addressid, RequestHelperClass helper)
	{
		Employee1 emp =null;
		EntityManager manager=fc.createEntityManager();
		List<Employee1> resultList=null;
		List<Address1> AddressList=null;
		//manager.getTransaction().begin();
		 emp = manager.find(Employee1.class, empid);
		 //manager.remove(Employee1.class);
		 Optional<Employee1> ofNullable = Optional.ofNullable(emp);
		 if(ofNullable.isPresent())
		 {
			 AddressList=emp.getAddressList();
			 Optional<Address1> findFirst = null;
			 Integer count=null;
					 findFirst = AddressList.stream()
					 .filter(s->s.getAddressId()
							 .equals(addressid)).findFirst();
					
			 if(findFirst.isPresent())
			 {count=AddressList.indexOf(findFirst.get());
				 System.out.println(AddressList.indexOf(findFirst.get())+"AddressList.indexOf(findFirst.get())");
				 if(helper.getAddress().size()>0)
				 {
					/*
					 * Address1 address1 = findFirst.get(); //address1.setAddressline();
					 * address1.setCity(helper.getAddress().get(0).getCity());
					 * address1.setcountry(helper.getAddress().get(0).getCountry());
					 * address1.setState(helper.getAddress().get(0).getState());
					 * address1.setPincode(helper.getAddress().get(0).getPincode());
					 * emp.getAddressList().remove(count); emp.getAddressList().add(address1);
					 */
				 Session unwrap=manager.unwrap(Session.class);
				 
				 unwrap.getTransaction().begin();
				// unwrap.saveOrUpdate(emp);
				 org.hibernate.query.Query createQuery = unwrap.createNativeQuery
						 ("update  ADDRESS_TABLE  set  ADDRESSLINE =:line ,COUNTRY =:country,CITY_NAME =:city,STATE_NAME =:state,PIN_CODE=:pincode where ADRESS_ID =:id ");
				 createQuery.setParameter("line", helper.getAddress().get(0).getAddressline());
				 createQuery.setParameter("country", helper.getAddress().get(0).getCountry());
				 createQuery.setParameter("city", helper.getAddress().get(0).getCity());
				 createQuery.setParameter("state", helper.getAddress().get(0).getState());
				 createQuery.setParameter("pincode", helper.getAddress().get(0).getPincode());
				 createQuery.setParameter("id", addressid);
				 int executeUpdate = createQuery.executeUpdate();
				 System.out.println(executeUpdate+"executeUpdate");
				 unwrap.getTransaction().commit();
			
				 return new Gson().toJson(emp.toString());
				 
				 }else
				 {
					 return new Gson().toJson("Address  is empty"); 
				 }
				 
			 }else
			 {
				 return new Gson().toJson("Address  not found ");  
			 }
		 }
		 else
		 {
			 return new Gson().toJson("User not found ");   
		 }
	
	}
}
