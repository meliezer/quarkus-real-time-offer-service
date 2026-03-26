package com.example.offers.api;

import com.example.offers.api.dto.EvaluateOfferRequest;
import com.example.offers.api.dto.EvaluateOfferResponse;
import com.example.offers.api.mapper.OfferResponseMapper;
import com.example.offers.application.OfferEvaluationService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/offers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OfferEvaluationResource {

    private final OfferEvaluationService offerEvaluationService;
    private final OfferResponseMapper offerResponseMapper;

    @Inject
    public OfferEvaluationResource(OfferEvaluationService offerEvaluationService,
            OfferResponseMapper offerResponseMapper) {
        this.offerEvaluationService = offerEvaluationService;
        this.offerResponseMapper = offerResponseMapper;
    }

    @POST
    @Path("/evaluate")
    public EvaluateOfferResponse evaluate(@Valid EvaluateOfferRequest request) {
        return offerResponseMapper.toResponse(offerEvaluationService.evaluate(request));
    }
}
