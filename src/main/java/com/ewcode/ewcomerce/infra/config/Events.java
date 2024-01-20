package com.ewcode.ewcomerce.infra.config;

public enum Events {
    CATALOG_EMIT("catalog-emit");

    private final String event;

    Events(String event) {
        this.event = event;
    }
}
