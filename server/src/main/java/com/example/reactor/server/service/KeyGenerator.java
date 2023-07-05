package com.example.reactor.server.service;

import com.example.reactor.server.domain.Key;
import com.example.reactor.server.domain.Server;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class KeyGenerator {
    private final Random randomGenerator = new Random();

    @SneakyThrows
    public Key generateKey(Integer keyLength) {

        var value = RandomStringUtils.random(keyLength, true, true);
        var expiration = ZonedDateTime.now().plusDays(randomGenerator.nextInt(100));
        var server = Server.getRandomServer();

        try {
            TimeUnit.SECONDS.sleep(1); // имитируем долгое формирование
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Key(value, expiration, server);
    }
}
