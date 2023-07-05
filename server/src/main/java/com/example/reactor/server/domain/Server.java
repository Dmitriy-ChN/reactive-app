package com.example.reactor.server.domain;

import java.util.Random;

public enum Server {
    ALPHA,
    DELTA,
    SIGMA,
    OMEGA;

    public static Server getRandomServer() {
        int index = new Random().nextInt(values().length);
        return values()[index];
    }
}
