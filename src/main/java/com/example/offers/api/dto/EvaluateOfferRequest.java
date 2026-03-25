package com.example.offers.api.dto;

public record EvaluateOfferRequest(String customerId, String segment, String country,
                                   String channel, String sessionId) {
}
