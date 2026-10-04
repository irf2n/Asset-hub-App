package com.allocator.asset_hub.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.allocator.asset_hub.dto.AllocationRequestDto;
import com.allocator.asset_hub.entity.Asset;
import com.allocator.asset_hub.entity.AssetAllocation;
import com.allocator.asset_hub.entity.AssetCategory;
import com.allocator.asset_hub.entity.AssetStatus;
import com.allocator.asset_hub.entity.User;
import com.allocator.asset_hub.exception.InvalidAllocationStateException;
import com.allocator.asset_hub.repository.AssetAllocationRepository;
import com.allocator.asset_hub.repository.AssetRepository;
import com.allocator.asset_hub.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class AllocationServiceTest {

    @Mock
    private AssetAllocationRepository allocationRepo;

    @Mock
    private AssetRepository assetRepo;

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private AllocationService allocationService;

    @Test
    void allocateAsset_ShouldThrowException_WhenAssetIsNotAvailable() {
        // 1. ARRANGE (Setup test data and mock behaviors)
        Long userId = 1L;
        Long assetId = 10L;

        User dummyUser = new User();
        dummyUser.setId(userId);

        AssetCategory category = new AssetCategory("Laptops", "Field computers");
        Asset alreadyAllocatedAsset = new Asset("SN-1234", "MacBook Pro", AssetStatus.ALLOCATED, category);
        alreadyAllocatedAsset.setId(assetId);

        AllocationRequestDto requestDto = new AllocationRequestDto(
                userId, 
                assetId, 
                LocalDate.now().plusDays(7), 
                "Test lease"
        );

        // Tell the mocks what to return when the service calls them
        Mockito.when(userRepo.findById(userId)).thenReturn(Optional.of(dummyUser));
        Mockito.when(assetRepo.findById(assetId)).thenReturn(Optional.of(alreadyAllocatedAsset));

        // 2. ACT & ASSERT (Expect the specific exception to be thrown)
        assertThrows(InvalidAllocationStateException.class, () -> {
            allocationService.allocateAsset(requestDto);
        });

        // 3. VERIFY (Ensure the database save was never executed)
        Mockito.verify(allocationRepo, Mockito.never()).save(Mockito.any(AssetAllocation.class));
    }
}