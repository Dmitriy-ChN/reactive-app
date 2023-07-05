package com.example.reactor.server.controller;

import com.example.reactor.server.domain.Key;
import com.example.reactor.server.service.KeyGenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KeyGenController {
    private final KeyGenService keyGenService;

    @GetMapping("/keys")
    public Flux<Key> getKeys(@RequestParam Integer length) {
        return keyGenService.generateKeys(length);
    }

    @GetMapping("/keys/single")
    public Mono<Key> getKey(@RequestParam Integer length) {
        return keyGenService.generateKey(length);
    }
}
