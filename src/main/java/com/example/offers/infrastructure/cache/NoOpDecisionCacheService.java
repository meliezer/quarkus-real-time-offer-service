package com.example.offers.infrastructure.cache;

import com.example.offers.application.cache.DecisionCacheService;
import com.example.offers.domain.model.OfferEvaluationResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class NoOpDecisionCacheService implements DecisionCacheService {

    @Override
    public Optional<OfferEvaluationResult> get(String cacheKey) {
        return Optional.empty();
    }

    @Override
    public void put(String cacheKey, OfferEvaluationResult result) {
        // no-op
    }
}
