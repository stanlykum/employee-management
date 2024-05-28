package com.jpmc.ems.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * It is used to provide a centralized and consistent way of handling and reporting
 * errors in the application. The enum constants represent the different types of
 * errors that can occur, and the fields errorCode and message provide the
 * necessary information to identify and describe the errors.
 */

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    DEPARTMENT_NOT_FOUND(101, "Department not found with name: ");

    private final int errorCode;
    private final String message;

}
