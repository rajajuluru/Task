/*
 * package com.task.model;
 * 
 * import javax.persistence.Column; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne;
 * 
 * public class UserAddress {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer
 * addressid;
 * 
 * @Column(name = "useruserId") private Integer useruserId;
 * 
 * @ManyToOne //@JoinColumn(name="useruserId" ,referencedColumnName =
 * "userId",insertable = false, updatable = false) private User user; public
 * User getUseruserid() { return user; } public void setUseruserid(User
 * useruserid) { this.user = useruserid; } public String getDoorno() { return
 * doorno; } public void setDoorno(String doorno) { this.doorno = doorno; }
 * public String getStreet() { return street; } public void setStreet(String
 * street) { this.street = street; } public String getCity() { return city; }
 * public void setCity(String city) { this.city = city; } private String doorno;
 * private String street; private String city;
 * 
 * }
 */