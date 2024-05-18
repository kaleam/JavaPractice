package com.example.ecom.adapters;

import com.example.ecom.libraries.GoogleMapsApi;
import com.example.ecom.libraries.models.GLocation;
import com.example.ecom.models.Address;
import org.springframework.stereotype.Service;

@Service
public class GoogleMapsDeliveryTimeEstimator implements EstimateDeliveryTimeAdapter{

    @Override
    public long estimate(double srcLatitude, double srcLongitude, double destLatitude, double destLongitude) {
        GLocation gLocationSrc = new GLocation();
        gLocationSrc.setLatitude(srcLatitude);
        gLocationSrc.setLongitude(srcLongitude);

        GLocation gLocationDest = new GLocation();
        gLocationDest.setLatitude(srcLatitude);
        gLocationDest.setLongitude(srcLongitude);

        GoogleMapsApi googleMapsApi = new GoogleMapsApi();
        return (long) googleMapsApi.estimate(gLocationSrc, gLocationDest) * 1000;
    }
}
