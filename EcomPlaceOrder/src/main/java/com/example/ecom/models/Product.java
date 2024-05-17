package com.example.ecom.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "product")
public class Product extends BaseModel{
    private String name;
    private String description;
    private double price;
}
