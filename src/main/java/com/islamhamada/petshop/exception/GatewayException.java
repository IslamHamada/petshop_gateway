package com.islamhamada.petshop.exception;

import com.islamhamada.petshop.contracts.exception.ServiceException;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GatewayException extends ServiceException {
    HttpStatus httpStatus;

    public GatewayException(String message, String error_code, HttpStatus httpStatus) {
        super(message, "GATEWAY_" + error_code);
        this.httpStatus = httpStatus;
    }
}
