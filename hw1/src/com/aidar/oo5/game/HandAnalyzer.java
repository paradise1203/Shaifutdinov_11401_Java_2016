package com.aidar.oo5.game;

import java.util.HashMap;
import java.util.Map;

public class HandAnalyzer {

    private Card[] board;
    private Player[] players;
    private Game.HandManager manager;

    public HandAnalyzer(Card[] board, Player[] players, Game.HandManager manager) {
        this.board = board;
        this.players = players;
        this.manager = manager;
    }

    /**
     * @return -2 if no one has combination
     * -1 of both have combination
     * 0 if player0 has combination
     * 1 if player1 has combination
     */
    private int compareComb(Card c1, Card c2) {
        if (c1 != null && c2 != null) {
            int res = c1.compareTo(c2);
            return res == 1 ? 0 : res == -1 ? 1 : -1;
        } else if (c1 != null) {
            return 0;
        } else if (c2 != null) {
            return 1;
        } else {
            return -2;
        }
    }

    private Card flash(Player p) {
        Card[] hand = p.getHand();
        Card c1 = hand[0];
        Card c2 = hand[1];
        if (c1.getSuit() == c2.getSuit()) {
            Card max = c1.compareTo(c2) == 1 ? c1 : c2;
            int count = 0;
            for (Card c : board) {
                if (c.getSuit() == max.getSuit()) {
                    count++;
                    if (c.compareTo(max) == 1) {
                        max = c;
                    }
                    if (count == 3) {
                        p.setDescription(" flash with " + max);
                        return max;
                    }
                }
            }
        } else {
            for (Card hC : hand) {
                Card max = hC;
                int count = 0;
                for (Card bH : board) {
                    if (bH.getSuit() == hC.getSuit()) {
                        count++;
                        if (bH.compareTo(max) == 1) {
                            max = bH;
                        }
                        if (count == 4) {
                            p.setDescription(" flash with " + max);
                            return max;
                        }
                    }
                }
            }
        }
        return null;
    }

    private Map<Card, Integer> getMatches(Player p) {
        Card[] hand = p.getHand();
        Map<Card, Integer> res = new HashMap<>();
        Card c1 = hand[0];
        if (c1.equals(hand[1])) {
            res.put(c1, 2);
        }
        for (int i = 0; i < board.length - 1; i++) {
            for (int j = i + 1; j < board.length; j++) {
                if (board[i].equals(board[j])) {
                    res.put(board[i], 2);
                }
            }
        }
        for (Card hC : hand) {
            for (Card bC : board) {
                if (hC.equals(bC)) {
                    if (res.containsKey(hC)) {
                        res.put(hC, res.get(hC) + 1);
                    } else {
                        res.put(hC, 2);
                    }
                }
            }
        }
        return res;
    }

    private Card fourOfAKind(Map<Card, Integer> matches, Player p) {
        for (Card c : matches.keySet()) {
            if (matches.get(c) == 4) {
                p.setDescription(" four of a kind " + c.getRank());
                return c;
            }
        }
        return null;
    }

    private Card threeOfAKind(Map<Card, Integer> matches, Player p) {
        Card max = null;
        for (Card c : matches.keySet()) {
            if (matches.get(c) == 3) {
                if (max != null) {
                    int res = c.compareTo(max);
                    max = res == 1 ? c : max;
                } else {
                    max = c;
                }
                p.setDescription(" three of a kind " + max.getRank());
            }
        }
        return max;
    }

    private Card twoPair(Map<Card, Integer> matches, Player p) {
        Card max = null;
        Card min = null;
        boolean hasOne = false;
        for (Card c : matches.keySet()) {
            if (matches.get(c) == 2) {
                if (hasOne) {
                    int res = c.compareTo(max);
                    if (res == 1) {
                        min = max;
                        max = c;
                    } else {
                        min = c.compareTo(min) == 1 ? c : min;
                    }
                    p.setDescription(" two pair " + max.getRank() + " and " + min.getRank());
                    return max;
                }
                max = min = c;
                hasOne = true;
            }
        }
        return null;
    }

    private Card onePair(Map<Card, Integer> matches, Player p) {
        Card max = null;
        for (Card c : matches.keySet()) {
            if (matches.get(c) == 2) {
                if (max != null) {
                    int res = c.compareTo(max);
                    max = res == 1 ? c : max;
                } else {
                    max = c;
                }
                p.setDescription(" one pair " + max.getRank());
            }
        }
        return max;
    }

    private Card highCard(Player p) {
        Card max = null;
        for (Card c : p.getHand()) {
            if (max != null) {
                max = c.compareTo(max) == 1 ? c : max;
            } else {
                max = c;
            }
        }
        p.setDescription(" high card " + max.getRank());
        return max;
    }

    private int pairs(Player p1, Player p2, Map<Card, Integer> matches1, Map<Card, Integer> matches2) {
        int res = compareComb(threeOfAKind(matches1, p1), fourOfAKind(matches2, p2));
        if (res > 0) {
            return res;
        }
        res = compareComb(twoPair(matches1, p1), twoPair(matches2, p2));
        if (res > 0) {
            return res;
        }
        res = compareComb(onePair(matches1, p1), onePair(matches2, p2));
        if (res > 0) {
            return res;
        }
        res = compareComb(highCard(p1), highCard(p2));
        if (res > 0) {
            return res;
        }
        return -1;
    }

    private int fullHouse(Player p1, Player p2, Map<Card, Integer> matches1, Map<Card, Integer> matches2) {
        Card trips1 = threeOfAKind(matches1, p1);
        Card pair1 = onePair(matches1, p1);
        Card trips2 = threeOfAKind(matches2, p2);
        Card pair2 = onePair(matches2, p2);
        if (trips1 != null && pair1 != null && trips2 != null && pair2 != null) {
            int res = compareComb(trips1, trips2);
            p1.setDescription(" full house with 3 " + trips1.getRank() + " and 2" + pair1.getRank());
            p2.setDescription(" full house with 3 " + trips2.getRank() + " and 2" + pair2.getRank());
            return res;
        } else if (trips1 != null && pair1 != null) {
            p1.setDescription(" full house with 3 " + trips1.getRank() + " and 2" + pair1.getRank());
            return 0;
        } else if (trips2 != null && pair2 != null) {
            p2.setDescription(" full house with 3 " + trips2.getRank() + " and 2" + pair2.getRank());
            return 1;
        }
        return -2;
    }

    public int analyze() {
        Player p1 = players[0];
        Player p2 = players[1];
        Map<Card, Integer> matches1 = getMatches(p1);
        Map<Card, Integer> matches2 = getMatches(p2);
        int res;
        res = fullHouse(p1, p2, matches1, matches2);
        if (res != -2) {
            return res;
        }
        res = compareComb(fourOfAKind(matches1, p1), fourOfAKind(matches2, p2));
        if (res != -2) {
            return res;
        }
        res = compareComb(flash(p1), flash(p2));
        if (res != -2) {
            return res;
        }
        res = pairs(p1, p2, matches1, matches2);
        return res;
    }

}
