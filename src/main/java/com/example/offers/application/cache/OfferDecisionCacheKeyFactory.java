package com.example.offers.application.cache;

import com.example.offers.api.dto.EvaluateOfferRequest;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OfferDecisionCacheKeyFactory {

    public String from(EvaluateOfferRequest request) {
        return String.join(":", normalize(request.customerId()), normalize(request.segment()),
                normalize(request.country()), normalize(request.channel()));
    }

    private String normalize(String value) {
        return value == null ? "null" : value.trim().toUpperCase();
    }
}
