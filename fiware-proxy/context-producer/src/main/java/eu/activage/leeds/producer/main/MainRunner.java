/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main;

import org.apache.commons.cli.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author te0003
 */
class MainRunner {

    private static final ArrayList<String> DEVICE_GROUPS = new ArrayList<>(Arrays.asList("home", "wearable", "adl", "notification"));
    private static final String APP_NAME = "ActivageLeeds IoT Platform Producer";
    private static final String APP_VERSION = "1.0";

    public static void main(String[] args) {

        //diagnostics
        try {
            Initialization initialization = new Initialization();
            initialization.initializeConfig();
            initialization.initializeDatabaseAccess();
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            return;
        }

        //handle command-line arguments
        Options options = getOptions();
        String deviceGroup;
        int interval;
        String uuid;
        CommandLineParser cmdParser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = cmdParser.parse(options, args, true);
            if (cmd.hasOption('v')) {
                System.out.println(APP_NAME + ", Version: " + APP_VERSION);
                return;
            }
            deviceGroup = cmd.getOptionValue("d");
            if (!DEVICE_GROUPS.contains(deviceGroup)) {
                throw new ParseException("Invalid device group");
            }
            interval = Integer.parseInt(cmd.getOptionValue("i"));
            uuid = cmd.getOptionValue("u");
        } catch (ParseException | NullPointerException | NumberFormatException ex) {
            if (ex instanceof ParseException) {
                System.err.println("Parsing failed.  Reason: " + ex.getLocalizedMessage());
            } else if (ex instanceof NumberFormatException) {
                System.err.println("Parsing failed.  Reason: Interval value is " + ex.getLocalizedMessage());
            }
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp(APP_NAME, options);
            return;
        }

//        List<PeriodicPoller> periodicPollers = new ArrayList<>();
        PeriodicDataPoller dataGroupPoller = new PeriodicDataPoller(deviceGroup, interval, uuid);
        Thread dataGroupThread = new Thread(dataGroupPoller);
        dataGroupThread.start();

    }

    private static Options getOptions() {

        Options options = new Options();
        options.addRequiredOption("d", "deviceGroup", true, "The device group to pull from; can be either \""
                + DEVICE_GROUPS.get(0) + "\", \""
                + DEVICE_GROUPS.get(1) + "\", \""
                + DEVICE_GROUPS.get(2) + "\", or \""
                + DEVICE_GROUPS.get(3) + "\".");
        options.addRequiredOption("i", "interval", true, "The interval time between polls in seconds.");
        options.addRequiredOption("u", "uuid", true, "The user UUID. Enter \"all\" for polling all users.");
        options.addOption("v", "version", false, "Application version.");

        return options;
    }

}
