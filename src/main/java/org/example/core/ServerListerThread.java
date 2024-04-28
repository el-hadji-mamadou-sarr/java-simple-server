package org.example.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerListerThread.class);
    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public ServerListerThread(int port, String webroot) throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {
        try {
            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = this.serverSocket.accept();
                LOGGER.info("* Connection accepted" + socket.getInetAddress());
                HttpConnectionWorkerThread workerThread = new HttpConnectionWorkerThread(socket);
                workerThread.start();

                /*  serverSocket.close();*/
            }

        } catch (IOException e) {
            LOGGER.error("Problem with setting socket");
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
