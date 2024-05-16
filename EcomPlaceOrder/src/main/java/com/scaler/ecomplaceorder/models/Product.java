package com.scaler.ecomplaceorder.models;

import lombok.Data;

@Data
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
}
