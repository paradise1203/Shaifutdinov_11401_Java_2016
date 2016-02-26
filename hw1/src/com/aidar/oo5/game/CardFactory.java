package com.aidar.oo5.game;


import com.aidar.oo5.enums.Rank;
import com.aidar.oo5.enums.Suit;

public class CardFactory {

    public static Card[] getDeck(int c) {
        Card[] deck = new Card[c];
        int i = 0;
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                if (i >= deck.length) {
                    return deck;
                }
                deck[i++] = new Card(r, s);
            }
        }
        return deck;
    }

}
