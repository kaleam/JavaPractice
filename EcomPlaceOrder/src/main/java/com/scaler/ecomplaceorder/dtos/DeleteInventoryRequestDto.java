package com.scaler.ecomplaceorder.dtos;

import lombok.Data;

@Data
public class DeleteInventoryRequestDto {
    private int userId;
    private int productId;
}
