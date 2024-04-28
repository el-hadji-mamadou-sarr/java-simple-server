package org.example;

import com.sun.net.httpserver.HttpServer;
import org.example.core.ServerListerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
/**
 * Http server
 *
 */
public class App 
{
    private final static Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )  {



        LOGGER.info("Server starting...");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf= ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("port:"+ conf.getPort());
        LOGGER.info("webRoot:"+ conf.getWebroot());
        try {
            ServerListerThread serverListerThread = new ServerListerThread((conf.getPort()),conf.getWebroot());
            serverListerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
