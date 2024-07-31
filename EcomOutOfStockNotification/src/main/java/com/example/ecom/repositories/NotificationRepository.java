package com.example.ecom.repositories;

import com.example.ecom.models.Notification;
import com.example.ecom.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findByProduct(Product product);
}
