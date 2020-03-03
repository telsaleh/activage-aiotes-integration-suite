/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.endpoint;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class ConsumerListener extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
//    public static final String restletPath = "/repo";
//    public static final String restletPath = "/v2";
//    public static final String registerPrefix = "/register";//POST
//    public static final String lookupPrefix = "/lookup";    //GET
//    public static final String updatePrefix = "/update";    //UPDATE
//    public static final String deletePrefix = "/remove";    //DELETE
//    public static final String sparqlPrefix = "/sparql";     //GET, POST    discover via SPARQL
//    public static final String searchPrefix = "/search";    //GET, POST     discover via Prob Engine
    private static final String registryPrefix = "/registry"; //POST
    public static final String sparqlPrefix = "/sparql"; //POST
    private static final String sanityCheckPrefix = "/version"; //POST

    public static void main(String[] args) throws Exception {
        
        Component ConsumerServer = new Component();
        ConsumerServer.getServers().add(Protocol.HTTP, 8000);
        ConsumerServer.getDefaultHost().attach(new ConsumerListener());
        ConsumerServer.start();
    }

    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        router.attach(sanityCheckPrefix, SanityCheck.class);

        router.attach(registryPrefix + "/{repository_id}", NotificationHandler.class); //POST
        router.attach(registryPrefix + "/{repository_id}/{resource_id}", NotificationHandler.class);  //GET, UPDATE, DELETE      

        return router;
    }

}
