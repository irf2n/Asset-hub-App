/**
 * 
 */
package com.allocator.asset_hub.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

/**
 * 
 */
@Entity
@Table(name = "asset_allocations")
public class AssetAllocation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", nullable = false)
private User user;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "asset_id", nullable = false)
private Asset asset;
@Column( name = "allocation_date", nullable = false)
private LocalDate allocationDate;
@Column(name = "return_date")
private LocalDate returnDate;
@Enumerated(EnumType.STRING)
@Column(nullable = false, length = 30)
private AllocationStatus status;
@Column(length =500)
private String notes;
// default constructor
public AssetAllocation() {}
// parameterized constructor
public AssetAllocation(User user, Asset asset, LocalDate allocationDate,AllocationStatus status, String notes) {
this.user = user;
this.asset = asset;
this.allocationDate = allocationDate;
this.status = status;
this.notes = notes;
}

// toString method
@Override
public String toString() {
	return "AssetAllocation [id=" + id
			+ ", user=" + (user != null? user.getFullName() : "null")
			+ ", asset=" + (asset != null ? asset.getModelName() + "(" + asset.getSerialNumber() + ")" : "null")
			+ ", allocationDate=" + allocationDate
			+ ", returnDate=" + returnDate
			+ ", status=" + status
			+ "]";
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
 * @return the user
 */
public User getUser() {
	return user;
}
/**
 * @param user the user to set
 */
public void setUser(User user) {
	this.user = user;
}
/**
 * @return the asset
 */
public Asset getAsset() {
	return asset;
}
/**
 * @param asset the asset to set
 */
public void setAsset(Asset asset) {
	this.asset = asset;
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
 * @return the returnDate
 */
public LocalDate getReturnDate() {
	return returnDate;
}
/**
 * @param returnDate the returnDate to set
 */
public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}
/**
 * @return the status
 */
public AllocationStatus getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(AllocationStatus status) {
	this.status = status;
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
