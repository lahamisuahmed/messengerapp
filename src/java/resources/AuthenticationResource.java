package resources;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import request.AuthenticationRequest;
import services.AuthenticationService;
import util.RequestParser;

/**
 * provide stateless restful service for authenticating users and managing JSON
 * web token
 *
 * @author Ajitata & Lawal
 */
@Path("auth")
public class AuthenticationResource {
    
    //<editor-fold defaultstate="collapsed" desc="LOGIN">
    
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@Context ContainerRequestContext containerRequestContext,
            @Context HttpServletRequest request,
            @Context HttpServletResponse response,
            JsonObject payload) {
        
        RequestParser parser = new RequestParser(payload);
        
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        
        authenticationRequest.loginValidator(parser.getData());
        
        AuthenticationService service = new AuthenticationService();
        
        JsonObject responseJSON = service.login(authenticationRequest, response);
        
        return Response.ok(responseJSON, MediaType.APPLICATION_JSON).build();
    }
//</editor-fold>
}
