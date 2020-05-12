package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.ws.rs.NameBinding;

/**
 *
 * @author Lawal */
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizationGate {
    
}
