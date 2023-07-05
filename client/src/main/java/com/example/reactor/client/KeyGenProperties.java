package com.example.reactor.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("keygen")
public record KeyGenProperties(String url) {}
