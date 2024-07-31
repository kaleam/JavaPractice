package com.example.ecom.services;

import com.example.ecom.exceptions.*;
import com.example.ecom.models.*;
import com.example.ecom.repositories.InventoryRepository;
import com.example.ecom.repositories.NotificationRepository;
import com.example.ecom.repositories.ProductRepository;
import com.example.ecom.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class NotificationServiceImpl implements NotificationService {
    private UserRepository userRepository;
    private ProductRepository productRepository;
    private InventoryRepository inventoryRepository;
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(UserRepository userRepository, ProductRepository productRepository, InventoryRepository inventoryRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;
        this.notificationRepository = notificationRepository;
    }


    @Override
    public Notification registerUser(int userId, int productId) throws UserNotFoundException, ProductNotFoundException, ProductInStockException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }

        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found!");
        }

        // Check if product is out of stock
        Product product = productOptional.get();
        Optional<Inventory> ineventoryOptional= this.inventoryRepository.findByProduct(product);
        if(ineventoryOptional.isEmpty() || ineventoryOptional.get().getQuantity() == 0){
            throw new ProductInStockException("Product is not in stock!");
        }

        Notification notification = new Notification();
        notification.setProduct(product);
        notification.setUser(userOptional.get());
        notification.setStatus(NotificationStatus.PENDING);
        this.notificationRepository.save(notification);

        return notification;
    }

    @Override
    public void deregisterUser(int userId, int notificationId) throws UserNotFoundException, NotificationNotFoundException, UnAuthorizedException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found!");
        }

        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
        if(notificationOptional.isEmpty()){
            throw new NotificationNotFoundException("Notification not found!");
        }

        User user = userOptional.get();
        Notification notification = notificationOptional.get();

        if(user.getId() != notification.getUser().getId()){
            throw new UnAuthorizedException("You are not allowed to deregister user!");
        }

        this.notificationRepository.delete(notification);
    }

    public void sendNotification(int productId) throws ProductNotFoundException{
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found!");
        }

        Product product = productOptional.get();
        Optional<Notification> notificationOptional = this.notificationRepository.findByProduct(product);
        if(notificationOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found!");
        }

        Notification notification = notificationOptional.get();

    }
}
