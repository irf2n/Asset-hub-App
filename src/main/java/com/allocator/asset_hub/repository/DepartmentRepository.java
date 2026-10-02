/**
 * 
 */
package com.allocator.asset_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allocator.asset_hub.entity.Department;

/**
 * 
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
