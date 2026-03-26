package com.example.offers.application;

import com.example.offers.api.dto.EvaluateOfferRequest;
import com.example.offers.application.cache.DecisionCacheService;
import com.example.offers.domain.model.DecisionSource;
import com.example.offers.domain.model.OfferDecision;
import com.example.offers.domain.model.OfferEvaluationResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class OfferEvaluationService {

    @Inject
    DecisionCacheService decisionCacheService;

    public OfferEvaluationResult evaluate(EvaluateOfferRequest request) {
        String cacheKey = buildCacheKey(request);

        return decisionCacheService.get(cacheKey).orElseGet(() -> evaluateFromRules(request));
    }

    private OfferEvaluationResult evaluateFromRules(EvaluateOfferRequest request) {
        return new OfferEvaluationResult(request.customerId(), request.segment(),
                DecisionSource.RULES, List.of(new OfferDecision("VIP_FREEBET", 95)));
    }

    private String buildCacheKey(EvaluateOfferRequest request) {
        return String.join(":", request.customerId(), request.segment(), request.country(),
                request.channel());
    }
}
