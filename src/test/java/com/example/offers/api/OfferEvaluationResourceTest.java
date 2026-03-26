package com.example.offers.api;

import com.example.offers.application.cache.DecisionCacheService;
import com.example.offers.domain.model.DecisionSource;
import com.example.offers.domain.model.OfferDecision;
import com.example.offers.domain.model.OfferEvaluationResult;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@QuarkusTest
class OfferEvaluationResourceTest {

    @InjectMock
    DecisionCacheService decisionCacheService;

    @Test
    void shouldEvaluateOffersFromRulesWhenCacheMiss() {
        when(decisionCacheService.get(anyString())).thenReturn(Optional.empty());

        String payload = """
                {
                  "customerId": "C123",
                  "segment": "VIP",
                  "country": "IT",
                  "channel": "WEB",
                  "sessionId": "S456"
                }
                """;

        given().contentType(ContentType.JSON).body(payload).when().post("/api/v1/offers/evaluate")
                .then().statusCode(200).body("customerId", equalTo("C123"))
                .body("segment", equalTo("VIP")).body("source", equalTo("RULES"))
                .body("offers.size()", greaterThan(0))
                .body("offers[0].code", equalTo("VIP_FREEBET"));
    }

    @Test
    void shouldReturnCachedDecisionWhenPresent() {
        when(decisionCacheService.get(anyString())).thenReturn(Optional.of(
                new OfferEvaluationResult("C123", "VIP", DecisionSource.CACHE,
                        List.of(new OfferDecision("VIP_CASHBACK", 99)))));

        String payload = """
                {
                  "customerId": "C123",
                  "segment": "VIP",
                  "country": "IT",
                  "channel": "WEB",
                  "sessionId": "S456"
                }
                """;

        given().contentType(ContentType.JSON).body(payload).when().post("/api/v1/offers/evaluate")
                .then().statusCode(200).body("customerId", equalTo("C123"))
                .body("segment", equalTo("VIP")).body("source", equalTo("CACHE"))
                .body("offers.size()", greaterThan(0))
                .body("offers[0].code", equalTo("VIP_CASHBACK"))
                .body("offers[0].score", equalTo(99));
    }

    @Test
    void shouldRejectRequestWhenCustomerIdIsMissing() {
        when(decisionCacheService.get(anyString())).thenReturn(Optional.empty());

        String payload = """
                {
                  "customerId": "",
                  "segment": "VIP",
                  "country": "IT",
                  "channel": "WEB",
                  "sessionId": "S456"
                }
                """;

        given().contentType(ContentType.JSON).body(payload).when().post("/api/v1/offers/evaluate")
                .then().statusCode(400).body("code", equalTo("VALIDATION_ERROR"));
    }
}
