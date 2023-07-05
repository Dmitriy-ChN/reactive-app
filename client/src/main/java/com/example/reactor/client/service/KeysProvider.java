package com.example.reactor.client.service;

import com.example.reactor.client.domain.Key;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface KeysProvider {
    Flux<Key> getKeys(Integer length);

    Mono<Key> getKey(Integer length);
}
