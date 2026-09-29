/**
 * 
 */
package com.allocator.asset_hub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "departments")

public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
@Column(nullable = false, unique = true)
 private String name;
@Column(nullable = false, unique = true, length= 10)
 private String code;
 
 // default Constructor
 public Department(){}
 
 // Parameterized Constructor
 
 public Long getId() {
	return id;
}

 public void setId(Long id) {
	this.id = id;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public String getCode() {
	return code;
 }

 public void setCode(String code) {
	this.code = code;
 }

 public Department(String name, String code) {
	 this.name = name;
	 this.code = code;
 }
	
}
