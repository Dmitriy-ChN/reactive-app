package com.example.reactor.server.service;

import com.example.reactor.server.domain.Key;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class KeyGenService {
    private final KeyGenerator generator;

    private static final Integer KEYS_PER_REQUEST = 100;

    public Flux<Key> generateKeys(Integer length) {
        return Flux.create((FluxSink<Key> sink) -> {
            for (int i = 0; i < KEYS_PER_REQUEST; i++) {
                var key = generator.generateKey(length);
                sink.next(key);
            }
        }).delayElements(Duration.ofMillis(1000));
    }

    public Mono<Key> generateKey(Integer length) {
        return Mono.just(generator.generateKey(length))
                .delayElement(Duration.ofMillis(1000));
    }
}
