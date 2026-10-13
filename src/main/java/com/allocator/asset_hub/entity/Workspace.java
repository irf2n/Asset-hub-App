
package com.allocator.asset_hub.entity;
/*
 * 
 * 
 * 
 */

import jakarta.persistence.*;

@Entity
@Table(name="workspaces")
public class Workspace{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	private String name;
	@Column(name = "floor_number", nullable = false)
	private int floorNumber;
	@Column(nullable = false, length = 100)
	private String building;
	/**
	 * 
	 */
	public Workspace() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param floorNumber
	 * @param building
	 */
	public Workspace(String name, int floorNumber, String building) {
		super();
		this.name = name;
		this.floorNumber = floorNumber;
		this.building = building;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the floorNumber
	 */
	public int getFloorNumber() {
		return floorNumber;
	}
	/**
	 * @param floorNumber the floorNumber to set
	 */
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	/**
	 * @return the building
	 */
	public String getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(String building) {
		this.building = building;
	}
	
	
	
}