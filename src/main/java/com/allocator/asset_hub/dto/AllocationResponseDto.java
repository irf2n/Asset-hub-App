/**
 * 
 */
package com.allocator.asset_hub.dto;

import java.time.LocalDate;

/**
 * 
 */
public class AllocationResponseDto {
private Long id;
private String userName;
private String assetSerialNumber;
private LocalDate allocationDate;
private String status;
// default constructor 
public AllocationResponseDto() {}
// parameterized constructor
/**
 * @param id
 * @param userName
 * @param assetSerialNumber
 * @param allocationDate
 * @param status
 */
public AllocationResponseDto(Long id, String userName, String assetSerialNumber, LocalDate allocationDate,
		String status) {

	this.id = id;
	this.userName = userName;
	this.assetSerialNumber = assetSerialNumber;
	this.allocationDate = allocationDate;
	this.status = status;
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
 * @return the userName
 */
public String getUserName() {
	return userName;
}
/**
 * @param userName the userName to set
 */
public void setUserName(String userName) {
	this.userName = userName;
}
/**
 * @return the assetSerialNumber
 */
public String getAssetSerialNumber() {
	return assetSerialNumber;
}
/**
 * @param assetSerialNumber the assetSerialNumber to set
 */
public void setAssetSerialNumber(String assetSerialNumber) {
	this.assetSerialNumber = assetSerialNumber;
}
/**
 * @return the allocationDate
 */
public LocalDate getAllocationDate() {
	return allocationDate;
}
/**
 * @param allocationDate the allocationDate to set
 */
public void setAllocationDate(LocalDate allocationDate) {
	this.allocationDate = allocationDate;
}
/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}


}
