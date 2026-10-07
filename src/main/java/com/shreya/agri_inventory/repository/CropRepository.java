package com.shreya.agri_inventory.repository;

import com.shreya.agri_inventory.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}