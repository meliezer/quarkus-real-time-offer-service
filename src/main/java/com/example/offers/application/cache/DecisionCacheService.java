package com.example.offers.application.cache;

import com.example.offers.domain.model.OfferEvaluationResult;

import java.util.Optional;

public interface DecisionCacheService {

    Optional<OfferEvaluationResult> get(String cacheKey);

    void put(String cacheKey, OfferEvaluationResult result);
}
