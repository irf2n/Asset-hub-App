package com.allocator.asset_hub;
import com.allocator.asset_hub.entity.*;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.allocator.asset_hub.entity.Department;
import com.allocator.asset_hub.entity.User;

@SpringBootApplication
public class AssetHubApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AssetHubApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n==========================================");
        System.out.println("   RUNNING SANITY CHECKS & DEBUG OUTPUT   ");
        System.out.println("==========================================");

        // 1. Test Department instantiation & encapsulation
        Department engineering = new Department("Engineering", "ENG");
        engineering.setId(1L); // manually setting an ID for the test in memory
        System.out.println("[DEBUG] Created Department: " + engineering);

        // 2. Test User creation linked to that Department
        User devUser = new User();
        devUser.setDepartment(engineering);
        devUser.setId(101L);
        System.out.println("[DEBUG] Created User: " + devUser);

        // 3. Test Field Mutators / Setters
        devUser.setRole("TECH_LEAD");
        System.out.println("[DEBUG] Role updated to: " + devUser.getRole());

        // 4. Test Relationship Traversal
        System.out.println("[DEBUG] User works in department code: " + devUser.getDepartment().getCode());

        System.out.println("==========================================\n");
    
        AssetCategory laptopCat = new AssetCategory("Laptops", "Portable developer computers");
        laptopCat.setId(10L);

        Asset thinkpad = new Asset("SN-TP-1001", "ThinkPad T14", AssetStatus.AVAILABLE, laptopCat);
        thinkpad.setId(501L);

        System.out.println("[DEBUG] Created Asset: " + thinkpad);

        // Test modifying enum status
        thinkpad.setStatus(AssetStatus.ALLOCATED);
        System.out.println("[DEBUG] Asset status transitioned to: " + thinkpad.getStatus());
     // Testing allocation link
        AssetAllocation allocation = new AssetAllocation(
            devUser, 
            thinkpad, 
            LocalDate.now(), 
            AllocationStatus.ACTIVE, 
            "Assigned for backend development duties"
        );
        allocation.setId(9001L);

        System.out.println("[DEBUG] Created Allocation: " + allocation);

        // Test closing the allocation (simulating an asset return)
        allocation.setReturnDate(LocalDate.now().plusMonths(3));
        allocation.setStatus(AllocationStatus.RETURNED);
        System.out.println("[DEBUG] Returned Allocation: " + allocation);
    
    }
}