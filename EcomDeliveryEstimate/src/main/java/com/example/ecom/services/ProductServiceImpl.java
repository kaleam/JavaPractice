package com.example.ecom.services;

import com.example.ecom.exceptions.AddressNotFoundException;
import com.example.ecom.exceptions.ProductNotFoundException;
import com.example.ecom.libraries.GoogleMapsApi;
import com.example.ecom.libraries.models.GLocation;
import com.example.ecom.models.Address;
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

    public ProductServiceImpl(ProductRepository productRepository, AddressRepository addressRepository, DeliveryHubRepository deliveryHubRepository) {
        this.productRepository = productRepository;
        this.addressRepository = addressRepository;
        this.deliveryHubRepository = deliveryHubRepository;
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
        Address sellerAddress = product.getSeller().getAddress();
        GLocation gLocationSource = new GLocation();
        gLocationSource.setLatitude(sellerAddress.getLatitude());
        gLocationSource.setLongitude(sellerAddress.getLongitude());

        // Get delivery hub address using seller address
        Optional<Address> deliveryAddressOptional = this.deliveryHubRepository.findByAddress_ZipCode(sellerAddress.getZipCode());
        if(deliveryAddressOptional.isEmpty()){
            throw new AddressNotFoundException("Delivery hub not found!");
        }
        Address deliveryAddress = deliveryAddressOptional.get();
        GLocation gLocationDeliveryHub = new GLocation();
        gLocationDeliveryHub.setLatitude(deliveryAddress.getLatitude());
        gLocationDeliveryHub.setLongitude(deliveryAddress.getLongitude());

        // Get dest address using address
        GLocation gLocationDest = new GLocation();
        Address address = addressOptional.get();
        gLocationDest.setLatitude(address.getLatitude());
        gLocationDest.setLongitude(address.getLongitude());

        // Invoke google map api to estimate delivery time
        GoogleMapsApi googleMapsApi = new GoogleMapsApi();
        long deliveryEstimateTimeSrcToHub = (long) googleMapsApi.estimate(gLocationSource,gLocationDeliveryHub) * 1000;
        long deliveryEstimateTimeHubToDest = (long) googleMapsApi.estimate(gLocationDeliveryHub,gLocationDest) * 1000;
        long totalEstimatedTime = deliveryEstimateTimeSrcToHub + deliveryEstimateTimeHubToDest + System.currentTimeMillis();

        // Return by converting estimated delivery time from int to Date
        return new Date(totalEstimatedTime);
    }
}
