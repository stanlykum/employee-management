package com.jpmc.ems.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
    private String details;
    private int statusCode;
    private int errorCode;
    private String message;
    private LocalDateTime timestamp;
}
