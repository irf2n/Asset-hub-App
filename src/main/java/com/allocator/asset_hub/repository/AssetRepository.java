/**
 * 
 */
package com.allocator.asset_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allocator.asset_hub.entity.Asset;
import com.allocator.asset_hub.entity.AssetStatus;

/**
 * 
 */
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

	List<Asset> findByStatus(AssetStatus status);
}
