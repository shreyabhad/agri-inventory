package com.shreya.agri_inventory.exception;

public class CropNotFoundException extends RuntimeException {

    public CropNotFoundException(Long id) {
        super("Crop with id " + id + " not found");
    }
}