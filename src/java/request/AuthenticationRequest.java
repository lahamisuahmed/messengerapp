package request;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import util.FormValidator;
import util.JB;

/**
 *
 * @author Lawal
 */
public class AuthenticationRequest implements Serializable {

    //sets application debug mode to true;
    public static final boolean DEBUG=true;
    
    //authentication activities parameters
    private String username;
    private String password;
    
    private final FormValidator validator;

    public AuthenticationRequest() {
        validator = new FormValidator();
    }
    
    public void loginValidator(JsonObject data){
        
        if(data.containsKey("username") && data.getString("username") != null){
            this.username = data.getString("username");
        }
        
        if(data.containsKey("password") && data.getString("password") != null){
            this.password = data.getString("password");
        }
        
        /*validate input*/
        boolean usernameEmpty = validator.isBlank(username);
        boolean passwordEmpty = validator.isBlank(password);
        
        if (usernameEmpty ||  passwordEmpty) {
            JsonObjectBuilder formError = Json.createObjectBuilder();
            JsonObjectBuilder responseData = Json.createObjectBuilder();
            
            validator.addError(usernameEmpty, "username", "enter a valid username", formError);
            validator.addError(passwordEmpty, "password", "enter a valid password", formError);
            
            responseData.add("form_errors", formError.build());
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.invalidFormInput(responseData.build())).type(MediaType.APPLICATION_JSON).build());
        }
    }
    
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
