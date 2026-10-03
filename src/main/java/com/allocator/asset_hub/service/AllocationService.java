/**
 * 
 */
package com.allocator.asset_hub.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.allocator.asset_hub.dto.AllocationRequestDto;
import com.allocator.asset_hub.dto.AllocationResponseDto;
import com.allocator.asset_hub.entity.AllocationStatus;
import com.allocator.asset_hub.entity.Asset;
import com.allocator.asset_hub.entity.AssetAllocation;
import com.allocator.asset_hub.entity.AssetStatus;
import com.allocator.asset_hub.entity.User;
import com.allocator.asset_hub.repository.AssetAllocationRepository;
import com.allocator.asset_hub.repository.AssetRepository;
import com.allocator.asset_hub.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Service
public class AllocationService {

	private final AssetAllocationRepository allocationRepo;
	private final AssetRepository assetRepo;
	private final UserRepository userRepo;
	/**
	 * @param allocationRepo
	 * @param assetRepo
	 * @param userRepo
	 */
	public AllocationService(AssetAllocationRepository allocationRepo, AssetRepository assetRepo,
			UserRepository userRepo) {
		this.allocationRepo = allocationRepo;
		this.assetRepo = assetRepo;
		this.userRepo = userRepo;
	}
	
	//method for transaction operation
	@Transactional
	public AllocationResponseDto allocateAsset(AllocationRequestDto requestDto) {
		
		User user = userRepo.findById(requestDto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + requestDto.getUserId()));
		
	    
		Asset asset = assetRepo.findById(requestDto.getAssetId())
				.orElseThrow(() -> new RuntimeException("Asset not found with id: " + requestDto.getAssetId()));
		if(asset.getStatus() != AssetStatus.AVAILABLE) {
			throw new RuntimeException("Asset is not available for allocation. Current status: " + asset.getStatus());
		} else { asset.setStatus(AssetStatus.ALLOCATED);
		}
		assetRepo.save(asset);
		
		
		AssetAllocation allocation = new AssetAllocation(
				user,
				asset,
				LocalDate.now(),
				AllocationStatus.ACTIVE,
				requestDto.getNotes()
				);
		if(requestDto.getReturnDate() != null) {
			allocation.setReturnDate(requestDto.getReturnDate());
		}
		AssetAllocation savedAllocation = allocationRepo.save(allocation);
		
		return new AllocationResponseDto(
				savedAllocation.getId(),
				user.getFullName(),
				asset.getSerialNumber(),
				savedAllocation.getAllocationDate(),
				savedAllocation.getStatus().name()
				);
	}
	
	// method for return operation 
	@Transactional
	public AllocationResponseDto returnAsset(Long allocationId) throws Exception {
		AssetAllocation allocation = allocationRepo.findById(allocationId)
		.orElseThrow(() -> new RuntimeException("Allocation record not found with the id: " + allocationId));
		
		if(allocation.getStatus() != AllocationStatus.ACTIVE) {
			 throw new RuntimeException ("Cannot return asset. Asset is not Active. Current status: " + allocation.getStatus());
		}
		// set return date
		allocation.setReturnDate(LocalDate.now());
		//set status
		allocation.setStatus(AllocationStatus.RETURNED);
		// persist change
		AssetAllocation updatedAllocation = allocationRepo.save(allocation);
		// to retrieve asset
		Asset asset = allocation.getAsset();
		// set status again
		asset.setStatus(AssetStatus.AVAILABLE);
		// persisting change 
		assetRepo.save(asset);
		
		return new AllocationResponseDto (
			updatedAllocation.getId(),
			allocation.getUser().getFullName(),
			asset.getSerialNumber(),
			updatedAllocation.getAllocationDate(),
			updatedAllocation.getStatus().name()
		);
	}
	
}
