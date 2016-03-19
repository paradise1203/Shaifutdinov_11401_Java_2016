package com.aidar.oo5.enums;

public enum SomeStaff {

    DECK(52),
    BOARD(5),
    HAND(2),

    BLIND(2),
    STACK(1000);

    private int value;

    private SomeStaff(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
