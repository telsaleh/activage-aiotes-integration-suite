/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.main;

import com.mongodb.client.MongoClient;
import eu.activage.leeds.producer.client.api.BatchUpdateOpClient;
import eu.activage.leeds.producer.client.api.SmartThingsQuery;
import eu.activage.leeds.producer.client.db.EnergenieQuery;
import eu.activage.leeds.producer.client.db.MongoConnection;
import eu.activage.leeds.producer.client.db.WearableQuery;
import eu.activage.leeds.producer.formatter.HomeNgsiFormatter;
import eu.activage.leeds.producer.formatter.WearableNgsiFormatter;
import eu.activage.leeds.producer.model.proxy.DeviceData;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author te0003
 */
public class PeriodicDataPoller implements Runnable {

    private final int interval;
    private final String dataService;
    private final String uuid;

    PeriodicDataPoller(String dataService, int interval, String uuid) {
        this.dataService = dataService;
        this.interval = interval;
        this.uuid = uuid;
    }

    @Override
    public void run() {                      
        

        //process runs continuosly
        while (true) {
            try {
                //set timer for data pull interval
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                calendar.add(Calendar.SECOND, interval);
                System.out.println("Next data collection ==> " + calendar.getTime());

                synchronized (this) {
                    this.wait(interval * 1000);
                }
//                this.wait(interval * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            BatchUpdateOpClient buoc = new BatchUpdateOpClient();
            try {
                List<DeviceData> ddl;
                String batchRequest = "";
                if (dataService.equalsIgnoreCase("home")) {
                    EnergenieQuery eq = new EnergenieQuery();
                    ddl = eq.getAllEnergenieData(uuid);
                    try {
                        SmartThingsQuery sq = new SmartThingsQuery();
                        ddl.addAll(sq.getAllSmartThingsData(uuid));
                    } catch (Exception ex) {
                        System.err.println("error getting SmartThings data");
                    }
                    HomeNgsiFormatter ngsiFormatter = new HomeNgsiFormatter();
                    batchRequest = ngsiFormatter.getNgsiFormat(ddl);
                } else if (dataService.equalsIgnoreCase("wearable")) {
                    WearableQuery wq = new WearableQuery();
                    ddl = wq.getAllWearableData(uuid);
                    WearableNgsiFormatter ngsiFormatter = new WearableNgsiFormatter();
                    batchRequest = ngsiFormatter.getNgsiFormat(ddl);
                } else {
                    System.err.println("Datatype not recognized, exiting...");
                    Runtime.getRuntime().exit(1);
                }
                buoc.updateEntities(batchRequest);

            } catch (Exception e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
}
