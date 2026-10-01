package com.allocator.asset_hub.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Asset{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "serial_number", nullable = false, unique = true, length = 100)
private String serialNumber;
@Column(name = "model_name", nullable = false, length = 120)
private String modelName;
@Enumerated(EnumType.STRING)
@Column(nullable = false , length = 30)
private AssetStatus status;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "category_id", nullable = false)
private AssetCategory category;
/**
 * default constructor
 */
public Asset() {}
/**
 * @param serialNumber
 * @param modelName
 * @param status
 * @param category
 */
public Asset( String serialNumber, String modelName, AssetStatus status, AssetCategory category) {
	this.serialNumber = serialNumber;
	this.modelName = modelName;
	this.status = status;
	this.category = category;
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
 * @return the serialNumber
 */
public String getSerialNumber() {
	return serialNumber;
}
/**
 * @param serialNumber the serialNumber to set
 */
public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}
/**
 * @return the modelName
 */
public String getModelName() {
	return modelName;
}
/**
 * @param modelName the modelName to set
 */
public void setModelName(String modelName) {
	this.modelName = modelName;
}
/**
 * @return the status
 */
public AssetStatus getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(AssetStatus status) {
	this.status = status;
}
/**
 * @return the category
 */
public AssetCategory getCategory() {
	return category;
}
/**
 * @param category the category to set
 */
public void setCategory(AssetCategory category) {
	this.category = category;
}
@Override
public String toString() {
	return "Asset [id=" + id + ", serialNumber=" + serialNumber + ", modelName=" + modelName + ", status=" + status
			+ ", category=" + category + ", getId()=" + getId() + ", getSerialNumber()=" + getSerialNumber()
			+ ", getModelName()=" + getModelName() + ", getStatus()=" + getStatus() + ", getCategory()=" + getCategory()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}






}