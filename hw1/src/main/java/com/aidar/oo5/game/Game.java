package com.aidar.oo5.game;


import com.aidar.oo5.Connection;
import com.aidar.oo5.enums.SomeStaff;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {

    private Connection[] connections;
    private Player[] players;

    private HandManager manager;

    /**
     * 0 - game is off
     * 1 - player 0 moves
     * 2 - player 1 moves
     */
    private int state;
    private int button;

    private Pattern pattern = Pattern.compile("^-raise (?<bet>\\d+)");

    class HandManager {

        private Card[] deck = new Card[SomeStaff.DECK.getValue()];
        private Card[] board = new Card[SomeStaff.BOARD.getValue()];
        private int bank = 0;
        private int blind = SomeStaff.BLIND.getValue();

        private int toCall = 0;
        /**
         * 0 - flop
         * 1 - turn
         * 2 - river
         * 3 - opening
         */
        private int street = 0;

        private HandAnalyzer analyzer = new HandAnalyzer(board, players, this);

        private void addElementFromDeck(Card[] mas, int i) {
            int index = 0;
            boolean found = false;
            while (!found) {
                index = (int) (Math.random() * (deck.length - 1));
                if (!deck[index].isUsed()) {
                    found = true;
                }
            }
            mas[i] = deck[index];
            deck[index].setUsed();
        }

        private void giveHand(Card[] hand) {
            for (int i = 0; i < hand.length; i++) {
                addElementFromDeck(hand, i);
            }
        }

        private void handInfo(Connection c, int i) {
            Card[] hand = players[i].getHand();
            c.sendMessage("Your stack : " + players[i].getStack() + " $ ; " +
                    "Your hand : " + hand[0] + " " + hand[1]);
            c.sendMessage("Bank : " + bank + " $ ");
        }

        private void shuffleUpAndDeal(int player) {
            deck = CardFactory.getDeck(deck.length);
            button = player;
            state = 1;
            giveHand(players[0].getHand());
            giveHand(players[1].getHand());
            Player p = players[button];
            boolean allIn = false;
            if (p.getStack() < blind) {
                int t = p.getStack();
                bank += t;
                p = players[1 - button];
                p.setStack(p.getStack() - t);
                allIn(button);
            } else {
                p.setStack(p.getStack() - blind);
                p = players[1 - button];
                p.setStack(p.getStack() - blind * 2);
                bank += blind * 3;
                toCall = blind;
            }
            for (int i = 0; i < connections.length; i++) {
                connections[i].sendMessage("server : Game is on!");
                handInfo(connections[i], i);
            }
            System.out.println("Cards have been dealt!");
        }

        private void refresh() {
            for (int i = 0; i < board.length; i++) {
                board[i] = null;
            }
            bank = 0;
            toCall = 0;
            street = 0;
            state = 0;
        }

        private void flop(int player) {
            for (int i = 0; i < 3; i++) {
                addElementFromDeck(board, i);
            }
            for (int i = 0; i < connections.length; i++) {
                connections[i].sendMessage("Flop : " + board[0] + " " + board[1] + " " + board[2]);
                handInfo(connections[i], i);
            }
        }

        private void turn(int player) {
            addElementFromDeck(board, 3);
            for (int i = 0; i < connections.length; i++) {
                connections[i].sendMessage("Turn : " + board[0] + " " + board[1] + " " + board[2] + " " + board[3]);
                handInfo(connections[i], i);
            }
        }

        private void river(int player) {
            addElementFromDeck(board, 4);
            for (int i = 0; i < connections.length; i++) {
                connections[i].sendMessage("River : " + board[0] + " " + board[1] + " " + board[2] + " "
                        + board[3] + " " + board[4]);
                handInfo(connections[i], i);
            }
        }

        private void opening() {
            System.out.println("Find out who is the winner");
            int winner = analyzer.analyze();
            if (winner == -1) {
                draw();
            } else {
                lose(1 - winner);
            }
        }

        private void draw() {
            System.out.println(bank + " $ bank is shared between two players");
            connections[0].sendMessage("You have won " + bank + " $ with " + players[0].getDescription());
            connections[1].sendMessage("You have won " + bank + " $ with " + players[1].getDescription());
            Player p = players[0];
            p.setStack(p.getStack() + bank / 2);
            p = players[1];
            p.setStack(p.getStack() + bank / 2);
            refresh();
        }

        private void lose(int player) {
            System.out.println(bank + " $ goes to player " + (1 - player));
            connections[player].sendMessage("You have lost this hand");
            connections[1 - player].sendMessage("You have won " + bank + " $ with " + players[1-player].getDescription());
            Player p = players[1 - player];
            p.setStack(p.getStack() + bank);
            refresh();
        }

    }

    private void showCommandsInfo() {
        for (Connection c : connections) {
            c.sendMessage("Available commands:");
            c.sendMessage("Start the game : -start");
            c.sendMessage("Check : -check");
            c.sendMessage("Call : -call");
            c.sendMessage("Fold : -fold");
            c.sendMessage("Raise x (x - amount of chips): -raise x");
        }
    }

    private void chooseStreet(int player) {
        switch (manager.street) {
            case 0:
                manager.flop(player);
                break;
            case 1:
                manager.turn(player);
                break;
            case 2:
                manager.river(player);
                break;
            case 3:
                manager.opening();
                return;
        }
        manager.street++;
        state = 2;
    }

    private void allIn(int player) {
        connections[player].sendMessage("You are all-in!");
        connections[1 - player].sendMessage("Opponent is all-in!");
        while (state != 0) {
            chooseStreet(player);
        }
    }

    private void call(int number) {
        if (manager.toCall == 0) {
            connections[number].sendMessage("There is nothing to call, maybe check?");
        } else {
            Player p = players[number];
            int n = p.getStack() - manager.toCall;
            if (n <= 0) {
                manager.bank += p.getStack();
                p.setStack(0);
                p = players[1 - number];
                p.setStack(p.getStack() + Math.abs(n));
                allIn(number);
            } else {
                p.setStack(p.getStack() - manager.toCall);
                manager.bank += manager.toCall;
                manager.toCall = 0;
                connections[1 - number].sendMessage("Opponent has called");
                chooseStreet(number);
            }
        }
    }

    public Game(Connection c1, Connection c2) {
        connections = new Connection[]{c1, c2};
        players = new Player[]{new Player(1000), new Player(1000)};
        manager = new HandManager();
        showCommandsInfo();
    }

    public void process(int number, String m) {
        switch (state) {
            case 0:
                if (m.equals("-start")) {
                    manager.shuffleUpAndDeal(number);
                } else {
                    connections[1 - number].sendMessage("Opponent : " + m);
                }
                break;
            case 1:
                if (button == number) {
                    Player p;
                    switch (m) {
                        case "-check":
                            if (manager.toCall != 0) {
                                connections[number].sendMessage("You can`t check in this situation!");
                            } else {
                                connections[1 - number].sendMessage("Opponent has checked");
                                chooseStreet(number);
                            }
                            break;
                        case "-fold":
                            connections[1 - number].sendMessage("Opponent has folded");
                            manager.lose(number);
                            break;
                        case "-call":
                            call(number);
                            break;
                        default:
                            Matcher matcher = pattern.matcher(m);
                            if (matcher.matches()) {
                                int bet = Integer.parseInt(matcher.group("bet"));
                                if (bet > players[number].getStack()) {
                                    connections[number].sendMessage("You don`t have enough chips to make this bet");
                                    break;
                                }
                                if (manager.toCall == 0) {
                                    if (bet >= manager.blind) {
                                        manager.toCall = bet;
                                        manager.bank += bet;
                                        p = players[number];
                                        p.setStack(p.getStack() - bet);
                                        state = 2;
                                        connections[1 - number].sendMessage("Opponent has bet " + bet + " $ ");
                                    } else {
                                        connections[number].sendMessage("You have to bet at least 1 bb");
                                    }
                                } else {
                                    if (bet < manager.toCall * 2) {
                                        connections[number].sendMessage("You have to raise at least twice");
                                    } else {
                                        manager.bank += bet;
                                        manager.toCall = bet - manager.toCall;
                                        p = players[number];
                                        p.setStack(p.getStack() - bet);
                                        state = 2;
                                        connections[1 - number].sendMessage("Opponent has raised " + bet + " $ ");
                                    }
                                }
                            } else {
                                connections[1 - number].sendMessage("Opponent : " + m);
                            }
                    }
                } else {
                    connections[1 - number].sendMessage("Opponent : " + m);
                }
                break;
            case 2:
                if (button != number) {
                    Player p;
                    switch (m) {
                        case "-check":
                            if (manager.toCall != 0) {
                                connections[number].sendMessage("You can`t check in this situation!");
                            } else {
                                connections[1 - number].sendMessage("Opponent has checked");
                                state = 1;
                            }
                            break;
                        case "-fold":
                            connections[1 - number].sendMessage("Opponent has folded");
                            manager.lose(number);
                            break;
                        case "-call":
                            call(number);
                            break;
                        default:
                            Matcher matcher = pattern.matcher(m);
                            if (matcher.matches()) {
                                int bet = Integer.parseInt(matcher.group("bet"));
                                if (bet > players[number].getStack()) {
                                    connections[number].sendMessage("You don`t have enough chips to make this bet");
                                    break;
                                }
                                if (manager.toCall == 0) {
                                    if (bet >= manager.blind) {
                                        manager.toCall = bet;
                                        manager.bank += bet;
                                        p = players[number];
                                        p.setStack(p.getStack() - bet);
                                        state = 1;
                                        connections[1 - number].sendMessage("Opponent has bet " + bet + " $ ");
                                    } else {
                                        connections[number].sendMessage("You have to bet at least 1 bb");
                                    }
                                } else {
                                    if (bet < manager.toCall * 2) {
                                        connections[number].sendMessage("You have to raise at least twice");
                                    } else {
                                        manager.bank += bet;
                                        manager.toCall = bet - manager.toCall;
                                        p = players[number];
                                        p.setStack(p.getStack() - bet);
                                        state = 1;
                                        connections[1 - number].sendMessage("Opponent has raised " + bet + " $ ");
                                    }
                                }
                            } else {
                                connections[1 - number].sendMessage("Opponent : " + m);
                            }
                    }
                } else {
                    connections[1 - number].sendMessage("Opponent : " + m);
                }
                break;
        }
    }

}
