package com.example.reactor.client.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeyReceiver {
    private final KeysProvider keysProvider;

    private static final Integer PARALLEL_KEYS_AMOUNT = 100;

    public void receiveKeys(Integer keyLength) {
        keysProvider.getKeys(keyLength)
                .subscribe(key -> log.info("received key: " + key.toString()));
    }

    public void receiveKeysParallel(Integer keyLength) {
        Flux.range(1, PARALLEL_KEYS_AMOUNT)
                .flatMap(n -> keysProvider.getKey(keyLength))
                .subscribe(key -> log.info("received key in parallel: " + key.toString()));
    }
}
