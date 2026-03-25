package com.example.offers.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest
class OfferEvaluationResourceTest {
    @Test
    void shouldEvaluateOffersFromRulesWhenCacheMiss() {
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
}
