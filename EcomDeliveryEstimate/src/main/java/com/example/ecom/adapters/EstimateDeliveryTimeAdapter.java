package com.example.ecom.adapters;

import org.springframework.stereotype.Service;

@Service
public interface EstimateDeliveryTimeAdapter {
    long estimate(double srcLatitude, double srcLongitude, double destLatitude, double destLongitude);
}
