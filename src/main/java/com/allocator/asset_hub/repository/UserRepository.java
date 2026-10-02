/**
 * 
 */
package com.allocator.asset_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allocator.asset_hub.entity.User;

/**
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByDepartmentId(Long departmentId);
}
