package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static  ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;
    private ConfigurationManager(){}
    public static ConfigurationManager getInstance(){
        if(myConfigurationManager ==null)
            myConfigurationManager = new ConfigurationManager();
        return myConfigurationManager;
    }
 /*
    * Used to load the config file
    * */
    public void loadConfigurationFile(String filePath)  {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(filePath);
        }catch(FileNotFoundException e){
           throw new HttpConfigurationExeption(e);
        }

        StringBuffer sb = new StringBuffer();
        int i;
        try {
            while((i=fileReader.read())!=-1){
                sb.append((char)i);
            }
        }catch (IOException e){
            throw new HttpConfigurationExeption(e);
        }
        JsonNode conf =null;
        try{
            conf = Json.parse(sb.toString());
        }catch (IOException e){
            throw new HttpConfigurationExeption("Error parsing the configuration file",e);
        }
    try{
        myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
    }catch (IOException e){
        throw new HttpConfigurationExeption("Error parsing the Configuration File internal",e);
    }

    }
    /*
    * Returns the Current loaded Configuration
    * */
    public Configuration getCurrentConfiguration(){
        if(myCurrentConfiguration ==null){
            throw new HttpConfigurationExeption("No Current Configuration Set.");
        }
        return myCurrentConfiguration;
    }
}
