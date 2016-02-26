package com.aidar.oo5.game;


import com.aidar.oo5.enums.SomeStaff;

public class Player {

    private int stack;
    private Card[] hand;
    private String description;

    public Player(int stack) {
        this.stack = stack;
        hand = new Card[SomeStaff.HAND.getValue()];
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
