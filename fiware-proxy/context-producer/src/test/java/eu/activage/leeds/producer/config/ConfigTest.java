/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.config;

//import eu.activage.leeds.proxy.config.Config;
import eu.activage.leeds.producer.config.ProducerConfig;
import org.junit.Test;

/**
 *
 * @author te0003
 */
public class ConfigTest {

    @Test
    public void getConfig() {

        try {
//            System.out.println("user home: "+System.getProperty("user.home"));
//            System.out.println("user dir: "+System.getProperty("user.dir"));
//            ProxyConfig config = ProxyConfig.getInstance();
//            System.out.println(config.getMongoHostname());
            System.out.println(ProducerConfig.getInstance().getMongoHostname());
            System.out.println(Integer.parseInt(ProducerConfig.getInstance().getMongoPort()));
            System.out.println(ProducerConfig.getInstance().getMongoAdminDb());
            System.out.println(ProducerConfig.getInstance().getMongoUsername());
            System.out.println(ProducerConfig.getInstance().getMongoPassword());
        } catch (Exception ex) {
            assert false;
        }

    }

}
