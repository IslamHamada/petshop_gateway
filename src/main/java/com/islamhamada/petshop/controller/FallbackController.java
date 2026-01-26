package com.islamhamada.petshop.controller;

import com.islamhamada.petshop.exception.GatewayException;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
public class FallbackController {

    @RequestMapping("/productServiceFallback")
    public ResponseEntity<String> productServiceFallback() {
        throw new GatewayException("Product service is down!", "PRODUCT_SERVICE_DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/userServiceFallback")
    public String userServiceFallback() {
        throw new GatewayException("User service is down!", "USER_SERVICE_DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/cartServiceFallback")
    public String cartServiceFallback() {
        throw new GatewayException("Cart service is down!", "CART_SERVICE_DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/orderServiceFallback")
    public String orderServiceFallback() {
        throw new GatewayException("Order service is down!", "ORDER_SERVICE_DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping("/reviewServiceFallback")
    public String reviewServiceFallback() {
        throw new GatewayException("Review service is down!", "REVIEW_SERVICE_DOWN", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
