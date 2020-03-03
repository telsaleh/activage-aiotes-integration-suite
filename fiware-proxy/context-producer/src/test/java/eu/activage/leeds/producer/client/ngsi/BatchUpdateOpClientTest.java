/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.ngsi;

import eu.activage.leeds.producer.client.api.BatchUpdateOpClient;
import org.junit.Test;

import java.util.Properties;

/**
 *
 * @author te0003
 */
public class BatchUpdateOpClientTest {

    protected Properties prop = new Properties();
    protected String configPath = "config/broker.properties";
    private final String examplePath = "model/ngsi/example/batch_update_op.json";

    @Test
    public void updateEntitiesFromFile() {

        String clientBody;
        AccessResourceFilesTest prf = new AccessResourceFilesTest();
        clientBody = prf.getFile(examplePath);
        BatchUpdateOpClient ngsiClient = new BatchUpdateOpClient();
        ngsiClient.updateEntities(clientBody);

    }

    
}
