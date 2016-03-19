package com.aidar.oo5;


import com.aidar.oo5.game.Game;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection extends Thread {

    private Game game;
    private int number;

    private PrintWriter writer;
    private Scanner reader;

    public Connection(Socket s1, int number) throws IOException {
        writer = new PrintWriter(s1.getOutputStream(), true);
        reader = new Scanner(s1.getInputStream());
        this.number = number;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void sendMessage(String m) {
        writer.println(m);
    }

    @Override
    public void run() {
        while (reader.hasNextLine()) {
            game.process(number, reader.nextLine());
        }
    }

}
