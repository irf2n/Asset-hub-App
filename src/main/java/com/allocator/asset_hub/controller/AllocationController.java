/**
 * 
 */
package com.allocator.asset_hub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allocator.asset_hub.dto.AllocationRequestDto;
import com.allocator.asset_hub.dto.AllocationResponseDto;
import com.allocator.asset_hub.service.AllocationService;

/**
 * 
 */
@RestController
@RequestMapping("/api/allocations")
public class AllocationController {
private final AllocationService allocationService;
//parameterized constructor
public AllocationController(AllocationService allocationService) {
	this.allocationService = allocationService;
}
// method for end point allocation creation 
@PostMapping
public ResponseEntity<AllocationResponseDto> createAllocation(@RequestBody AllocationRequestDto requestDto){
	AllocationResponseDto response = allocationService.allocateAsset(requestDto);
	return new ResponseEntity<>(response, HttpStatus.CREATED);
}
// end point --> asset
@PutMapping("/{id}/return")
public ResponseEntity<AllocationResponseDto> returnAsset(@PathVariable Long id) throws Exception{
	AllocationResponseDto response = allocationService.returnAsset(id);

	return ResponseEntity.ok(response);
}
}
