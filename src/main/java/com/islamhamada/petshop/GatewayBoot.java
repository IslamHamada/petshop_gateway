package com.islamhamada.petshop;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayBoot {

	public static void main(String[] args) {
		SpringApplication.run(GatewayBoot.class, args);
	}

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> resilience4JCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.build());
	}
}
