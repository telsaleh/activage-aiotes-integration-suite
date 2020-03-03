/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchpad;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author te0003
 */
class File_IO {

    public static void main(String[] args) {
        
        String dbProps = "";
        String apiProps = "";
        
        try (InputStream input = File_IO.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            
            dbProps = prop.getProperty("eu.activage.leeds.proxy.activageleeds.db");
            apiProps = prop.getProperty("eu.activage.leeds.proxy.activageleeds.api");

            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.contains("Windows")) {
            dbProps = "%LOCALAPPDATA%" + dbProps;
            System.out.println(dbProps);

        } else if (os.contains("Linux")) {
            System.out.println(false);
        } else {
            System.out.println("OS Unknown");
        }

    }

}
