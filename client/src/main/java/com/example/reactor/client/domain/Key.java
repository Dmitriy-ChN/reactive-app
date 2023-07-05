package com.example.reactor.client.domain;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Key {
    private String value;
    private ZonedDateTime expiration;
    private String server;
}
