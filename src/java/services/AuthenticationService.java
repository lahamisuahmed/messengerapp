package services;

import cipher.PasswordCipher;
import constants.JsonConstant;
import dao.ProfileDAO;
import entity.Profile;
import java.util.Optional;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import request.AuthenticationRequest;
import util.JB;

/**
 *
 * @author lawal
 */
public class AuthenticationService {

//    TokenManager tokenManager;
    public AuthenticationService() {
//        tokenManager = TokenManager.getInstance();
    }

    //<editor-fold defaultstate="collapsed" desc="LOGIN">
    public JsonObject login(AuthenticationRequest authenticationRequest, HttpServletResponse response) {

        ProfileDAO profileDAO = new ProfileDAO();

        Optional<Profile> optionalProfile = profileDAO.findProfile(authenticationRequest.getUsername());

        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();

            PasswordCipher cipher = new PasswordCipher();

            if (cipher.check(authenticationRequest.getPassword(), profile.getPassword())) {

                //generate jwt 
                //data
                JsonObjectBuilder data = Json.createObjectBuilder();
                data.add("access-token", "uytrewqasdffghj");
                data.add("refresh-token", "kdjdjfhfhhf");
                data.add("name", profile.getFirstName() + " " + profile.getSurname());

                return JB.createOkResponse(data.build());

            } else {
                throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).entity(JB.buildErrorResponse(JsonConstant.STATUS_401, JsonConstant.UNAUTHORIZED, JsonConstant.INVALID_LOGIN_CREDENTIALS)).type(MediaType.APPLICATION_JSON).build());
            }
        } else {
            throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).entity(JB.buildErrorResponse(JsonConstant.STATUS_401, JsonConstant.UNAUTHORIZED, JsonConstant.INVALID_LOGIN_CREDENTIALS)).type(MediaType.APPLICATION_JSON).build());
        }
    }
//</editor-fold>
}
