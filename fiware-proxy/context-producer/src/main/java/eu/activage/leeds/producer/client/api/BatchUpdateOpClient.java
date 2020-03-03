/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.producer.client.api;

import eu.activage.leeds.producer.config.ProducerConfig;
import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te0003
 */
public class BatchUpdateOpClient {

//    private final Properties prop = new Properties();
//    private final String configPath = "config/api.properties";
    
    public void updateEntities(String clientBody) {

        // read properties file
//        try {
//            InputStream inputStream;
//            inputStream = getClass().getClassLoader().getResourceAsStream(configPath);
//
//            if (inputStream != null) {
//                prop.load(inputStream);
//            } else {
//                throw new FileNotFoundException("property file '" + configPath + "' not found in the classpath");
//            }
//        } catch (IOException e) {
//            e.getMessage();
//            return;
//        }

        //read host URL
//        String brokerHostUrl = prop.getProperty("activageleeds.iot_platform.api.host") + prop.getProperty("activageleeds.iot_platform.api.batch_update_op");
        String brokerHostUrl = ProducerConfig.getInstance().getIotPlatformHost()+ ProducerConfig.getInstance().getBatchUpdateOpPath();
        System.out.println("Target URL is: " + brokerHostUrl);

        // contruct client body
        // send client request
        final Context context = new Context();
        Client client = new Client(new Context(), Protocol.HTTP);
        client.getContext().getParameters().add("maxConnectionsPerHost", "5");
        client.getContext().getParameters().add("maxTotalConnections", "5");
//        client.getContext().getParameters().add("socketTimeout", prop.getProperty("client.socket.timeout"));
        client.getContext().getParameters().add("socketTimeout", ProducerConfig.getInstance().getClientSocketTimeout());

        final ClientResource clientResource = new ClientResource(context, brokerHostUrl);
        clientResource.setNext(client);
        clientResource.accept(MediaType.APPLICATION_JSON);
        clientResource.getLogger().setLevel(Level.WARNING);
        String statusCode = "";
        String responseBody = "";

        try {
            Representation result = clientResource.post(new StringRepresentation(clientBody, MediaType.APPLICATION_JSON));
//            ocbClientResource.release();
            
            try {
                responseBody = result.getText();
                statusCode = clientResource.getStatus().getCode() + " (" + clientResource.getStatus().getReasonPhrase() + ")";
            } catch (IOException ex) {
                Logger.getLogger(BatchUpdateOpClient.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR: " + ex.getLocalizedMessage());
            }

        } catch (ResourceException ex) {
            Logger.getLogger(BatchUpdateOpClient.class.getName()).log(Level.SEVERE, null, ex);
            statusCode = ex.getStatus().getReasonPhrase() + " (" + ex.getStatus().getCode() + ")";
            System.out.println("StatusCode: " + statusCode);
            responseBody = ex.getResponse().getEntityAsText();
            assert (ex.getStatus().isSuccess());
        }

        System.out.println("Response body is: " + responseBody);
        System.out.println("Status code is: " + statusCode);

    }

}
