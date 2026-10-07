package com.shreya.agri_inventory.controller;

import com.shreya.agri_inventory.entity.Crop;
import com.shreya.agri_inventory.service.CropService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping
    public ResponseEntity<Crop> createCrop(@Valid @RequestBody Crop crop) {
        Crop createdCrop = cropService.createCrop(crop);
        return ResponseEntity.ok(createdCrop);
    }

    @GetMapping
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.ok(cropService.getAllCrops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Long id) {
        return cropService.getCropById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Crop> updateCrop(
            @PathVariable Long id,
            @Valid @RequestBody Crop updatedCrop) {

        Crop crop = cropService.updateCrop(id, updatedCrop);
        return ResponseEntity.ok(crop);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCrop(@PathVariable Long id) {
        try {
            cropService.deleteCrop(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}