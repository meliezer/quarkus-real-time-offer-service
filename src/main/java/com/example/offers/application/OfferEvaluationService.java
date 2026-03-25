package com.example.offers.application;

import com.example.offers.api.dto.EvaluateOfferRequest;
import com.example.offers.domain.model.DecisionSource;
import com.example.offers.domain.model.OfferDecision;
import com.example.offers.domain.model.OfferEvaluationResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OfferEvaluationService {
    public OfferEvaluationResult evaluate(EvaluateOfferRequest request) {
        return new OfferEvaluationResult(request.customerId(), request.segment(),
                DecisionSource.RULES, List.of(new OfferDecision("VIP_FREEBET", 95)));
    }
}
