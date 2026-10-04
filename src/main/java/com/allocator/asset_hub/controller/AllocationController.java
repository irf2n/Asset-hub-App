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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Asset Allocations", description = "Endpoints for leasing and returning corporate hardware assets")
@RestController
@RequestMapping("/api/allocations")
public class AllocationController {

    private final AllocationService allocationService;

    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @Operation(summary = "Allocate an asset to a user", description = "Creates an active allocation lease record if the asset is AVAILABLE.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Asset allocated successfully"),
        @ApiResponse(responseCode = "400", description = "Asset is already allocated or request payload validation failed"),
        @ApiResponse(responseCode = "404", description = "User or Asset ID not found")
    })
    @PostMapping
    public ResponseEntity<AllocationResponseDto> createAllocation(@Valid @RequestBody AllocationRequestDto requestDto) {
        AllocationResponseDto response = allocationService.allocateAsset(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Return an allocated asset", description = "Transitions an active allocation to RETURNED and resets the asset to AVAILABLE.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Asset returned successfully"),
        @ApiResponse(responseCode = "400", description = "Allocation is not in ACTIVE state"),
        @ApiResponse(responseCode = "404", description = "Allocation record not found")
    })
    @PutMapping("/{id}/return")
    public ResponseEntity<AllocationResponseDto> returnAsset(@PathVariable Long id) {
        AllocationResponseDto response = allocationService.returnAsset(id);
        return ResponseEntity.ok(response);
    }
}