package com.example.ecom.controllers;

import com.example.ecom.dtos.DeliveryEstimateRequestDto;
import com.example.ecom.dtos.DeliveryEstimateResponseDto;
import com.example.ecom.dtos.ResponseStatus;
import com.example.ecom.services.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public DeliveryEstimateResponseDto estimateDeliveryTime(DeliveryEstimateRequestDto requestDto){
        DeliveryEstimateResponseDto response = new DeliveryEstimateResponseDto();
        try{
            response.setExpectedDeliveryDate(this.productService.estimateDeliveryDate(requestDto.getProductId(),requestDto.getAddressId()));
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
