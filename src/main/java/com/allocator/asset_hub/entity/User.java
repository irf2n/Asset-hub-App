/**
 * 
 */
package com.allocator.asset_hub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "full_name", nullable = false, length = 150)
private String fullName;
@Column(nullable = false, unique = true, length = 150)
private String email;
@Column(nullable = false , length = 30)
private String role;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "department_id", nullable = false)
private Department department;
// default Constructor
public User() {}
/**
 * @param id
 * @param fullName
 * @param email
 * @param role
 * @param department
 */
public User(String fullName, String email, String role, Department department) {

	this.fullName = fullName;
	this.email = email;
	this.role = role;
	this.department = department;
}
/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
/**
 * @return the fullName
 */
public String getFullName() {
	return fullName;
}
/**
 * @param fullName the fullName to set
 */
public void setFullName(String fullName) {
	this.fullName = fullName;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the role
 */
public String getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(String role) {
	this.role = role;
}
/**
 * @return the department
 */
public Department getDepartment() {
	return department;
}
/**
 * @param department the department to set
 */
public void setDepartment(Department department) {
	this.department = department;
}


}
