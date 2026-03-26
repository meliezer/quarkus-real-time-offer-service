package com.example.offers.api.dto;

import jakarta.validation.constraints.NotBlank;

public record EvaluateOfferRequest(
        @NotBlank(message = "customerId must not be blank") String customerId,

        @NotBlank(message = "segment must not be blank") String segment,

        @NotBlank(message = "country must not be blank") String country,

        @NotBlank(message = "channel must not be blank") String channel,

        @NotBlank(message = "sessionId must not be blank") String sessionId) {
}
