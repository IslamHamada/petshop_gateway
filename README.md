# API Gateway

Single entry point for the platform: routing + JWT validation.

# Runs on
- Port: 9090

# Depends on
- Service Registry (Eureka): `http://localhost:8081`
- Config Server: `http://localhost:8082`
- Zipkin: `http://localhost:9411`

## Description
Implements routing, JWT validation, CORS configuration, and request forwarding.  
Handles Auth0 access tokens and exposes the unified API.

## Tech Stack
- Java 17  
- Spring Boot 3.x  
- Spring Cloud Gateway  

## Related
Full project overview:  
https://github.com/IslamHamada/petshop
