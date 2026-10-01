/**
 * 
 */
package com.allocator.asset_hub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allocator.asset_hub.entity.AllocationStatus;
import com.allocator.asset_hub.entity.AssetAllocation;

/**
 * 
 */
@Repository
public interface AssetAllocationRepository extends JpaRepository<AssetAllocation, Long> {

	List<AssetAllocation> findByUserId(Long userId);
	Optional<AssetAllocation> findByAssetIdAndStatus(Long assetId, AllocationStatus status)
}
