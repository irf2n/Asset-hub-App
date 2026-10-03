/**
 * 
 */
package com.allocator.asset_hub.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

/**
 * 
 */
public class AllocationRequestDto {
@NotNull(message = "User ID is required")
private Long userId;
@NotNull(message = "Asset ID is required")
private Long assetId;
@Future(message = "Return date must be in the future")
private LocalDate returnDate;
private String notes;
// default constructor
public AllocationRequestDto() {}
// parameterized constructor
/**
 * @param userId
 * @param assetId
 * @param localDate
 * @param notes
 */
public AllocationRequestDto(Long userId, Long assetId, LocalDate returnDate, String notes) {

	this.userId = userId;
	this.assetId = assetId;
	this.returnDate = returnDate;
	this.notes = notes;
}
/**
 * @return the userId
 */
public Long getUserId() {
	return userId;
}
/**
 * @param userId the userId to set
 */
public void setUserId(Long userId) {
	this.userId = userId;
}
/**
 * @return the assetId
 */
public Long getAssetId() {
	return assetId;
}
/**
 * @param assetId the assetId to set
 */
public void setAssetId(Long assetId) {
	this.assetId = assetId;
}
/**
 * @return the localDate
 */
public LocalDate getReturnDate() {
	return returnDate;
}
/**
 * @param localDate the localDate to set
 */
public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}
/**
 * @return the notes
 */
public String getNotes() {
	return notes;
}
/**
 * @param notes the notes to set
 */
public void setNotes(String notes) {
	this.notes = notes;
}


}
