package com.example.offers.api.dto;

import java.util.List;

public record ApiErrorResponse(String code, String message, List<String> details) {
}
