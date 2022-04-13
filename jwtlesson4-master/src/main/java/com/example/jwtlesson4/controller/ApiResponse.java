package com.example.jwtlesson4.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean success;
    private Object object;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
