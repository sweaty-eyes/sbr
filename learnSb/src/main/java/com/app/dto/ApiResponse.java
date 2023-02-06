package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
    private LocalDate localDate;
    private String message;
    private String id;

    public ApiResponse(String message) {
        this.localDate = LocalDate.now();
        this.message = message;
    }

    public ApiResponse(UUID uuid) {
        this.id = uuid.toString();
    }
}
