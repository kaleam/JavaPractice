package com.scaler.ecomplaceorder.controllers;

import com.scaler.ecomplaceorder.dtos.*;
import com.scaler.ecomplaceorder.services.InventoryService;

public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public CreateOrUpdateResponseDto createOrUpdateInventory(CreateOrUpdateRequestDto requestDto){
        return null;
    }

    public DeleteInventoryResponseDto deleteInventory(DeleteInventoryRequestDto requestDto){
        return null;
    }
}
