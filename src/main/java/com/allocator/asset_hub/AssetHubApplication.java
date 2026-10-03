package com.allocator.asset_hub;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.allocator.asset_hub.entity.Asset;
import com.allocator.asset_hub.entity.AssetCategory;
import com.allocator.asset_hub.entity.AssetStatus;
import com.allocator.asset_hub.entity.Department;
import com.allocator.asset_hub.entity.User;
import com.allocator.asset_hub.repository.AssetCategoryRepository;
import com.allocator.asset_hub.repository.AssetRepository;
import com.allocator.asset_hub.repository.DepartmentRepository;
import com.allocator.asset_hub.repository.UserRepository;

@SpringBootApplication
public class AssetHubApplication implements CommandLineRunner {
	
	// 1. Declare the repository dependencies
    private final DepartmentRepository departmentRepo;
    private final UserRepository userRepo;
    private final AssetCategoryRepository categoryRepo;
    private final AssetRepository assetRepo;

    // 2. Inject them via Constructor
    public AssetHubApplication(DepartmentRepository departmentRepo,
                               UserRepository userRepo,
                               AssetCategoryRepository categoryRepo,
                               AssetRepository assetRepo) {
        this.departmentRepo = departmentRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
        this.assetRepo = assetRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(AssetHubApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> SEEDING BASELINE DATA FOR API TESTING <<<");

        Department itDept = new Department("Information Technology", "IT");
        departmentRepo.save(itDept);

        User john = new User("John Doe", "john.doe@company.com", "ENGINEER", itDept);
        userRepo.save(john);

        AssetCategory laptops = new AssetCategory("Laptops", "Portable workstations");
        categoryRepo.save(laptops);

        Asset thinkpad = new Asset("SN-TP-9900", "ThinkPad X1 Carbon", AssetStatus.AVAILABLE, laptops);
        assetRepo.save(thinkpad);

        System.out.println(">>> SEEDING COMPLETE: User ID = " + john.getId() + ", Asset ID = " + thinkpad.getId() + " <<<");
    }
    

}