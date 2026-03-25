package com.example.offers.application;

import com.example.offers.api.dto.EvaluateOfferRequest;
import com.example.offers.api.dto.EvaluateOfferResponse;
import com.example.offers.api.dto.OfferDecisionDto;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OfferEvaluationService {
    public EvaluateOfferResponse evaluate(EvaluateOfferRequest request) {
        return new EvaluateOfferResponse(request.customerId(), request.segment(), "RULES",
                List.of(new OfferDecisionDto("VIP_FREEBET", 95)));
    }
}
