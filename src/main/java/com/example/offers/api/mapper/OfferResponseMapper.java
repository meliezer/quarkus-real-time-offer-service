package com.example.offers.api.mapper;

import com.example.offers.api.dto.EvaluateOfferResponse;
import com.example.offers.api.dto.OfferDecisionDto;
import com.example.offers.domain.model.OfferDecision;
import com.example.offers.domain.model.OfferEvaluationResult;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OfferResponseMapper {
    public EvaluateOfferResponse toResponse(OfferEvaluationResult result) {
        return new EvaluateOfferResponse(result.customerId(), result.segment(),
                result.source().name(), mapOffers(result.offers()));
    }

    private List<OfferDecisionDto> mapOffers(List<OfferDecision> offers) {
        return offers.stream().map(offer -> new OfferDecisionDto(offer.code(), offer.score()))
                .toList();
    }
}
