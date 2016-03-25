package com.aidar.oo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by paradise on 20.03.16.
 */
@Component
public class SocketFactory {

    @Autowired
    private ServerSocket ss;

    public Socket getSocket() throws IOException {
        return ss.accept();
    }

}
