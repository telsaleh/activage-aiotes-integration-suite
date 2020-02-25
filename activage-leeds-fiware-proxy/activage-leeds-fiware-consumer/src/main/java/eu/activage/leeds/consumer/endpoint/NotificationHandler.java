/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.activage.leeds.consumer.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import eu.activage.leeds.consumer.response.RegistrationResponse;

/**
 * Resource which has only one representation.
 */
public class NotificationHandler extends ServerResource {
    
    ObjectMapper objectMapper = new ObjectMapper();

    @Post
    public Representation handleRegister(Representation entity) throws ResourceException, IOException {

        String repositoryId = (String) getRequest().getAttributes().get("repository_id");
        String requestBody = entity.getText();

        String errorMessage = "";
        boolean parseError = false;
        RegistrationResponse registrationResponse = new RegistrationResponse();
        StringReader requestStringReader = new StringReader("");
        
        StringRepresentation result = new StringRepresentation("");

        try {
            requestStringReader = new StringReader(requestBody);
        } catch (NullPointerException npe) {
            errorMessage = npe.getLocalizedMessage();
            registrationResponse = new RegistrationResponse();
            result = new StringRepresentation(objectMapper.writeValueAsString(registrationResponse));
            result.setMediaType(MediaType.APPLICATION_JSON);
            return result;
        }

        result = new StringRepresentation(objectMapper.writeValueAsString(registrationResponse));
        result.setMediaType(MediaType.APPLICATION_JSON);

        return result;
    }


}
