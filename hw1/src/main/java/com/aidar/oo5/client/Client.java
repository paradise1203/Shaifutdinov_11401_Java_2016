package com.aidar.oo5.client;

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
        Socket socket = new Socket("localhost", 4568);
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
