package com.scaler.ecomplaceorder.models;

import lombok.Data;

@Data
public class Inventory extends BaseModel{
    private Product product;
    private int quantity;
}
