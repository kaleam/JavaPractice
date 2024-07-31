package com.example.ecom.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Notification extends BaseModel{
    @OneToOne
    private Product product;
    @ManyToOne
    private User user;
    private NotificationStatus status;
}
