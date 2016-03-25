package com.aidar.oo5;


import com.aidar.oo5.game.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static void sendMessage(String message, Socket s) throws IOException {
        new PrintWriter(s.getOutputStream(), true).println(message);
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("oo8-spring-config.xml");
        ServerSocket ss = new ServerSocket(4568);
        while (true) {
            Socket s1 = ss.accept();
            System.out.println("New user is connected! Waiting for another one");
            Socket s2 = ss.accept();
            sendMessage("Welcome! You can start playing whenever you wish :)", s2);
            sendMessage("Your enemy is here! You can start playing whenever you wish :)", s1);
            Connection c1 = new Connection(s1, 0);
            Connection c2 = new Connection(s2, 1);
            Game game = new Game(c1, c2);
            c1.setGame(game);
            c2.setGame(game);
            c1.start();
            c2.start();
        }
    }

}
