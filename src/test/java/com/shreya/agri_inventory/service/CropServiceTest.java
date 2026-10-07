package com.shreya.agri_inventory.service;

import com.shreya.agri_inventory.entity.Crop;
import com.shreya.agri_inventory.repository.CropRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CropServiceTest {

    @Mock
    private CropRepository cropRepository;

    @InjectMocks
    private CropService cropService;

    @Test
    void createCrop_shouldSaveCrop() {

        Crop crop = new Crop(
                "Wheat",
                "Cereal",
                500,
                "kg"
        );

        when(cropRepository.save(crop)).thenReturn(crop);

        Crop result = cropService.createCrop(crop);

        assertEquals("Wheat", result.getCropName());
        assertEquals("Cereal", result.getCategory());
        assertEquals(500, result.getQuantity());
        assertEquals("kg", result.getUnit());

        verify(cropRepository).save(crop);
    }
}