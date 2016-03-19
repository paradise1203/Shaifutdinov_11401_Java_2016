package com.aidar.oo5.enums;

public enum Suit {

    HEARTS("h"),
    DIAMONDS("d"),
    CLUBS("c"),
    SPADES("s");

    private String value;

    private Suit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
