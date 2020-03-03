/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main.demo;

import org.apache.commons.cli.*;

/**
 *
 * @author te0003
 */
class MainRunnerDemo {

    public static void main(String[] args) {
        
        Options options = new Options();        
        options.addRequiredOption("t", "deviceType", true, "the data source to pull from; can be either \"door\" or \"motion\"");        
        options.addRequiredOption("i", "interval", true, "the interval time between polls, in seconds");
        options.addRequiredOption("d", "deviceId", true, "the device ID");
        options.addRequiredOption("u", "uuid", true, "the user ID");
        String deviceType;
        String deviceId;
        String uuid;
        int interval; 
        
         CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            deviceType = cmd.getOptionValue("t");
            deviceId = cmd.getOptionValue("d");
            interval = Integer.parseInt(cmd.getOptionValue("i"));
            uuid = cmd.getOptionValue("u");
        } catch (ParseException | NullPointerException | NumberFormatException ex) {
            if (ex instanceof ParseException) {
                System.err.println("Parsing failed.  Reason: " + ex.getLocalizedMessage());
            } else if (ex instanceof NumberFormatException) {
                System.err.println("Parsing failed.  Reason: Interval value is " + ex.getLocalizedMessage());                
            }
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("proxy", options);
            return;
        }
        
        System.out.println("RUNNING IN DEMO MODE!");
        System.out.println("Device type: " + deviceType);
        System.out.println("Poll interval: " + interval);
        System.out.println("Device ID: " + deviceId);
        System.out.println("User ID: " + uuid);
        VirtualSensor virtualDoorSensor = new VirtualSensor(deviceType, interval, deviceId, uuid);
//        VirtualSensor virtualMotionSensor = new VirtualSensor("motion", "114931", "5d7a562e4b574561c24bd331");
        
        Thread doorThread = new Thread(virtualDoorSensor);
        doorThread.start();
        
        
    }

}
