package com.example.ecom.services;

import com.example.ecom.adapters.EstimateDeliveryTimeAdapter;
import com.example.ecom.exceptions.AddressNotFoundException;
import com.example.ecom.exceptions.ProductNotFoundException;
import com.example.ecom.models.Address;
import com.example.ecom.models.DeliveryHub;
import com.example.ecom.models.Product;
import com.example.ecom.repositories.AddressRepository;
import com.example.ecom.repositories.DeliveryHubRepository;
import com.example.ecom.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private AddressRepository addressRepository;
    private DeliveryHubRepository deliveryHubRepository;
    private EstimateDeliveryTimeAdapter estimateDeliveryTimeAdapter;

    public ProductServiceImpl(ProductRepository productRepository, AddressRepository addressRepository, DeliveryHubRepository deliveryHubRepository, EstimateDeliveryTimeAdapter estimateDeliveryTimeAdapter) {
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.deliveryHubRepository = deliveryHubRepository;
        this.estimateDeliveryTimeAdapter = estimateDeliveryTimeAdapter;
    }

    @Override
    public Date estimateDeliveryDate(int productId, int addressId) throws ProductNotFoundException, AddressNotFoundException {
        Optional<Product> productOptional = productRepository.findById((long) productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product not found!");
        }

        Optional<Address> addressOptional = addressRepository.findById((long) addressId);
        if(addressOptional.isEmpty()){
            throw new AddressNotFoundException("Address not found!");
        }

        // Get source address using product
        Product product = productOptional.get();
        Address customerAddress = addressOptional.get();
        Address sellerAddress = product.getSeller().getAddress();

        // Get delivery hub address using seller address
        Optional<DeliveryHub> deliveryHubOptional = this.deliveryHubRepository.findByAddress_ZipCode(sellerAddress.getZipCode());
        if(deliveryHubOptional.isEmpty()){
            throw new AddressNotFoundException("Delivery hub not found!");
        }
        Address hubAddress = deliveryHubOptional.get().getAddress();

        // Invoke estimate delivery time adapter
        long deliveryEstimateTimeSrcToHub = this.estimateDeliveryTimeAdapter.estimate(sellerAddress.getLatitude(), sellerAddress.getLongitude(), hubAddress.getLatitude(), hubAddress.getLongitude());
        long deliveryEstimateTimeHubToDest = this.estimateDeliveryTimeAdapter.estimate(hubAddress.getLatitude(),hubAddress.getLongitude(), customerAddress.getLatitude(), customerAddress.getLongitude());
        long totalEstimatedTime = deliveryEstimateTimeSrcToHub + deliveryEstimateTimeHubToDest + System.currentTimeMillis();

        // Return by converting estimated delivery time from int to Date
        return new Date(totalEstimatedTime);
    }
}
