package com.product.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;

@Configuration
public class OtlpConfiguration {
	@Bean
	OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${management.otlp.tracing.endpoint}") String url) {
		return OtlpHttpSpanExporter.builder().setEndpoint(url).build();
	}

}
