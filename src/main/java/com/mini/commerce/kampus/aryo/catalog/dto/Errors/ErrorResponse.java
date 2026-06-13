package com.mini.commerce.kampus.aryo.catalog.dto.Errors;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private Map<String, String> details;
    private LocalDateTime timestamp;
}
