package com.aidar.oo5.game;

import com.aidar.oo5.enums.Rank;
import com.aidar.oo5.enums.Suit;
import com.sun.istack.internal.NotNull;

public class Card implements Comparable {

    private Rank rank;
    private Suit suit;
    private boolean used;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.used = false;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed() {
        this.used = true;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!this.getClass().isInstance(obj)) {
            return false;
        }
        Card card = (Card) obj;
        return this.rank == card.rank;
    }

    @Override
    public int hashCode() {
        return rank.ordinal();
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    @Override
    public int compareTo(@NotNull Object o) {
        Card card = (Card) o;
        int r1 = this.getRank().ordinal();
        int r2 = card.getRank().ordinal();
        if (r1 > r2) {
            return 1;
        } else if (r1 < r2) {
            return -1;
        } else {
            return 0;
        }
    }

}
