package com.example.reactor.client.adapter;

import com.example.reactor.client.KeyGenProperties;
import com.example.reactor.client.domain.Key;
import com.example.reactor.client.service.KeysProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebKeyProvider implements KeysProvider {
    private final WebClient webClient = WebClient.create();
    private final KeyGenProperties keyGenProperties;

    @Override
    public Flux<Key> getKeys(Integer length) {
        return webClient.get()
                .uri(keyGenProperties.url() + "/api/keys?length=" + length)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Key.class);
    }

    @Override
    public Mono<Key> getKey(Integer length) {
        return webClient.get()
                .uri(keyGenProperties.url() + "/api/keys/single?length=" + length)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Key.class);
    }
}
