/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;


/**
 *
 * @author te0003
 */
// Singleton
public class ProducerConfig {

    private static ProducerConfig instance;

    private  String mongoHostname;
    private  String mongoPort;
    private  String mongoUsername;
    private  String mongoPassword;
    private  String mongoAdminDb;

    private  String iotPlatformHost;
    private  String batchUpdateOpPath;
    private  String smartThingsApiUrl;    

    private String windowsRootDirectory;
    private final String linuxRootDirectory = "/etc";
    private String clientSocketTimeout;

    private ProducerConfig() {

        String dbProps = "";
        String apiProps = "";
        Properties prop = new Properties();

        try (InputStream input = ProducerConfig.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input == null) {
                System.out.println("Unable to find config.properties");
                return;
            }
            //load a properties file from class path, inside static method
            prop.load(input);
            dbProps = prop.getProperty("eu.activage.leeds.proxy.activageleeds.db");
            apiProps = prop.getProperty("eu.activage.leeds.proxy.activageleeds.api");
        } catch (IOException ex) {
            System.out.println("Sorry, unable to load database and/or API paths");
            return;
        }

        String os = System.getProperty("os.name");
        Map<String, String> env = System.getenv();
        if (os.contains("Windows")) {
            windowsRootDirectory = env.get("LOCALAPPDATA");
            dbProps = windowsRootDirectory + dbProps;
            apiProps = windowsRootDirectory + apiProps;
        } else if (os.contains("Linux")) {
            dbProps = linuxRootDirectory + dbProps;
            apiProps = linuxRootDirectory + apiProps;
            System.out.println(false);
        } else {            
            throw new IllegalArgumentException("OS Not Supported"); 
//            System.err.println("OS Unknown");
//            return;
        }

        try {
            System.out.println(dbProps);
            File configFile = new File(dbProps);
            InputStream inputStream = new FileInputStream(configFile);
            prop.load(inputStream);
            //load a properties file from class path, inside static method
            this.mongoHostname = prop.getProperty("activageleeds.mongodb.hostname");
            this.mongoPort = prop.getProperty("activageleeds.mongodb.port");
            this.mongoUsername = prop.getProperty("activageleeds.mongodb.username");
            this.mongoPassword = prop.getProperty("activageleeds.mongodb.password");
            this.mongoAdminDb = prop.getProperty("activageleeds.mongodb.db.admin");
            prop.load(inputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            File configFile = new File(apiProps);
            InputStream inputStream = new FileInputStream(configFile);
            prop.load(inputStream);
            this.iotPlatformHost = prop.getProperty("activageleeds.iot_platform.api.host");
            this.batchUpdateOpPath = prop.getProperty("activageleeds.iot_platform.api.batch_update_op");
            this.smartThingsApiUrl = prop.getProperty("activageleeds.smartthings.api");
            this.clientSocketTimeout = prop.getProperty("client.socket.timeout");
            //load a properties file from class path, inside static method
            prop.load(inputStream);
        } catch (IOException ex) {
        }

    }

    public String getClientSocketTimeout() {
        return clientSocketTimeout;
    }

    public static synchronized ProducerConfig getInstance() {
        if (instance == null) {
            instance = new ProducerConfig();
        }
        return instance;
    }
    
    public String getMongoHostname() {
        return mongoHostname;
    }

    public String getMongoPort() {
        return mongoPort;
    }

    public String getMongoUsername() {
        return mongoUsername;
    }

    public String getMongoPassword() {
        return mongoPassword;
    }

    public String getMongoAdminDb() {
        return mongoAdminDb;
    }

    public String getIotPlatformHost() {
        return iotPlatformHost;
    }

    public String getBatchUpdateOpPath() {
        return batchUpdateOpPath;
    }

    public String getSmartThingsApiUrl() {
        return smartThingsApiUrl;
    }

    public String getWindowsRootDirectory() {
        return windowsRootDirectory;
    }

    public String getLinuxRootDirectory() {
        return linuxRootDirectory;
    }
}
