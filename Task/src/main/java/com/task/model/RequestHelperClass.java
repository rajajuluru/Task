package com.task.model;  
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;  
  
@Component 
@RequestScope
public class RequestHelperClass {    
    
	
private Integer employeeId;    
	private String name, email;

	private Integer Addressid;
	
	
							
//@OneToMany(mappedBy = "employee")  
//@JoinColumn(name="Address1_Address1id",insertable=false, updatable=false,referencedColumnName = "Address1Id")
private List<Address2> address;  
public Integer getEmployeeId() {  
    return employeeId;  
}  
public void setEmployeeId(Integer employeeId) {  
    this.employeeId = employeeId;  
}  

@Override
public String toString() {
	return "RequestHelperClass [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", Addressid="
			+ Addressid + ", address=" + address + "]";
}
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
	
	  public List<Address2> getAddress() { return address; } public void
	 
	 setAddress(List<Address2> Address1) { this.address = Address1; }
	  
}  