package resources;

import javax.json.JsonObject;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import services.NuhuService;

@Path("nuhu")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NuhuResource {

    public NuhuResource() {
    }

    @GET
    public JsonObject getJson() {
        NuhuService service = new NuhuService();
        return service.getPersons();
    }

    @PUT
    public JsonObject putJson(JsonObject object) {
        NuhuService service = new NuhuService();
        return service.putJson(object);
    }

    @DELETE
    public JsonObject delete(JsonObject object) {
        NuhuService service = new NuhuService();
        return service.delete(object);
    }

    @POST
    public JsonObject post(JsonObject object) {
        NuhuService service = new NuhuService();
        return service.post(object);
    }

}
