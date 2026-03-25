package com.example.offers.api.dto;

import java.util.List;

public record EvaluateOfferResponse(String customerId, String segment, String source,
                                    List<OfferDecisionDto> offers) {
}
