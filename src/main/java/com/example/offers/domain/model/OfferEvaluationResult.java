package com.example.offers.domain.model;

import java.util.List;

public record OfferEvaluationResult(String customerId, String segment, DecisionSource source,
                                    List<OfferDecision> offers) {
}
