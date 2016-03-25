package com.aidar.oo5.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Scanner reader;

    private class ThreadReader extends Thread {
        public void run() {
            while (true) {
                if (reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
            }
        }
    }

    private Client() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("oo8-spring-config.xml");
        Socket socket = (Socket) context.getBean("socket");
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new Scanner(socket.getInputStream());
        Scanner input = new Scanner(System.in);
        new ThreadReader().start();
        while (true) {
            if (input.hasNextLine()) {
                writer.println(input.nextLine());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Client();
    }

}
