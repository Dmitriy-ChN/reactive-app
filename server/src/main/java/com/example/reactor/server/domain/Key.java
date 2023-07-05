package com.example.reactor.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class Key {
    private String value;
    private ZonedDateTime expiration;
    private Server server;
}
