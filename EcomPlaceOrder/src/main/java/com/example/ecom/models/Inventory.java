package com.example.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "inventory")
public class Inventory extends BaseModel{
    @ManyToOne
    private Product product;
    private int quantity;
}
