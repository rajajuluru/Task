/*
 * package com.task.model;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.CascadeType; import javax.persistence.Column; import
 * javax.persistence.Entity; import javax.persistence.GeneratedValue; import
 * javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.OneToMany; import
 * javax.persistence.Table; import javax.persistence.UniqueConstraint;
 * 
 * import org.springframework.stereotype.Component;
 * 
 * 
 * @Component
 * 
 * @Entity
 * 
 * @Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"emailId"})})
 * public class User {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "userId") private Integer userId; private String name;
 * 
 * private String emailId;
 * 
 * @OneToMany(mappedBy = "user") //@JoinColumn(name="userId",
 * referencedColumnName="userid",insertable = false, updatable = false) private
 * List<UserAddress> userAddressList;
 * 
 * public Integer getUserId() { return userId;
 * 
 * }
 * 
 * public void setUserId(Integer userId) { this.userId = userId; } public String
 * getName() { return name; } public void setName(String name) { this.name =
 * name; } public String getEmailId() { return emailId; } public User() {
 * super(); } public void setEmailId(String emailId) { this.emailId = emailId; }
 * 
 * public List<UserAddress> getUserAddress() { return userAddressList; } public
 * void setUserAddress(List<UserAddress> userAddress) { this.userAddressList
 * =userAddress; }
 * 
 * public User(Integer userId, String name, String emailId, List<UserAddress>
 * userAddress) { super(); this.userId = userId; this.name = name; this.emailId
 * = emailId; //this.userAddress = userAddress; }
 * 
 * 
 * }
 */