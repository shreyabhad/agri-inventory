package com.shreya.agri_inventory.service;

import com.shreya.agri_inventory.entity.Crop;
import com.shreya.agri_inventory.exception.CropNotFoundException;
import com.shreya.agri_inventory.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    private final CropRepository cropRepository;

    public CropService(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public Optional<Crop> getCropById(Long id) {
        return cropRepository.findById(id);
    }

    public Crop updateCrop(Long id, Crop updatedCrop) {
        Crop existingCrop = cropRepository.findById(id)
                .orElseThrow(() -> new CropNotFoundException(id));

        existingCrop.setCropName(updatedCrop.getCropName());
        existingCrop.setCategory(updatedCrop.getCategory());
        existingCrop.setQuantity(updatedCrop.getQuantity());
        existingCrop.setUnit(updatedCrop.getUnit());

        return cropRepository.save(existingCrop);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}