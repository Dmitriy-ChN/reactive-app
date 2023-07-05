package com.example.reactor.client.controller;

import com.example.reactor.client.service.KeyReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StartController {
    private final KeyReceiver keyReceiver;

    @GetMapping("/keys")
    public void getKeys(@RequestParam Integer length) {
        keyReceiver.receiveKeys(length);
    }

    @GetMapping("/keys/parallel")
    public void getKeysParallel(@RequestParam Integer length) {
        keyReceiver.receiveKeysParallel(length);
    }
}
