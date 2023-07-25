package com.bikers.app.common.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Error {
    private final String name;
    private final String message;
    private final Boolean isSuccessful;
}
