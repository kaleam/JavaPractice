package com.example.ecom.controllers;

import com.example.ecom.dtos.*;
import com.example.ecom.exceptions.ProductNotFoundException;
import com.example.ecom.exceptions.UnAuthorizedAccessException;
import com.example.ecom.exceptions.UserNotFoundException;
import com.example.ecom.models.Inventory;
import com.example.ecom.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public CreateOrUpdateResponseDto createOrUpdateInventory(CreateOrUpdateRequestDto requestDto) {
        CreateOrUpdateResponseDto response = new CreateOrUpdateResponseDto();
        try {
            Inventory inventory = this.inventoryService.createOrUpdateInventory(requestDto.getUserId(), requestDto.getProductId(), requestDto.getQuantity());
            response.setInventory(inventory);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (UserNotFoundException | ProductNotFoundException | UnAuthorizedAccessException e) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

    public DeleteInventoryResponseDto deleteInventory(DeleteInventoryRequestDto requestDto){
        DeleteInventoryResponseDto response = new DeleteInventoryResponseDto();
        try{
            this.inventoryService.deleteInventory(requestDto.getUserId(),requestDto.getProductId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(UserNotFoundException | UnAuthorizedAccessException e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
