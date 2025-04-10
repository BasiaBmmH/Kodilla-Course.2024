package com.kodilla.patterns.strategy.social;

public non-sealed class ZGeneration extends User {

    public ZGeneration(String username) {
        super(username);
        this.socialPublisher = new SnapchatPublisher();
    }
}
