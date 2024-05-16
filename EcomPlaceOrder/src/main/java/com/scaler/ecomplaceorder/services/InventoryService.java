package com.scaler.ecomplaceorder.services;

import com.scaler.ecomplaceorder.exceptions.ProductNotFoundException;
import com.scaler.ecomplaceorder.exceptions.UnAuthorizedAccessException;
import com.scaler.ecomplaceorder.exceptions.UserNotFoundException;
import com.scaler.ecomplaceorder.models.Inventory;

public interface InventoryService {
    public Inventory createOrUpdateInventory(int userId, int productId, int quantity) throws ProductNotFoundException, UserNotFoundException, UnAuthorizedAccessException;
    public void deleteInventory(int userId, int productId) throws  UserNotFoundException, UnAuthorizedAccessException;
}
