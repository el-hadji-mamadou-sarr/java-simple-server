package org.example.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            String html = "<html><head><title>Simple java server</title></head><body><h1>this page was served using java http server</h1></body></html>";
            final String CRLF = "\n\r";
            String response = "HTTP/1.1 200 OK" + CRLF + "Content-Length" + html.getBytes().length + CRLF + CRLF + html + CRLF + CRLF;//status line
            outputStream.write(response.getBytes());
            LOGGER.info("processing finished");
        } catch (IOException e) {
            LOGGER.error("Problem with communication");
            e.printStackTrace();
        } finally {

            if (inputStream != null) {
                try {

                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
