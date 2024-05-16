package com.scaler.ecomplaceorder.dtos;

import com.scaler.ecomplaceorder.models.Inventory;
import lombok.Data;

@Data
public class CreateOrUpdateResponseDto {
    private Inventory inventory;
    private ResponseStatus responseStatus;
}
