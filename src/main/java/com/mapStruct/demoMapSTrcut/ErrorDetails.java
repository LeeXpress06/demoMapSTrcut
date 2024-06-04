package com.mapStruct.demoMapSTrcut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private String message;
    private String path;
    private String errorCode;
    private LocalTime localTime;

    public ErrorDetails(String message, String description, String userNotFound, LocalDateTime now) {
    }
}
