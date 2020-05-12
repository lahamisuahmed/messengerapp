package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequestParser {

    JsonObject meta;
    JsonObject data;

    public RequestParser(InputStream input) {
        try {
            Reader reader = new InputStreamReader(input, "UTF-8");
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject payload = jsonReader.readObject();
            if (payload.getJsonObject("meta") == null || payload.getJsonObject("data") == null) {
                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.buildBadRequest()).type(MediaType.APPLICATION_JSON).build());
            }

            this.data = payload.getJsonObject("data");
            this.meta = payload.getJsonObject("meta");

            if (!isValidSource(meta)) {
                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.buildBadRequest()).type(MediaType.APPLICATION_JSON).build());
            }

        } catch (IOException ex) {
            Logger.getLogger(RequestParser.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.buildBadRequest()).type(MediaType.APPLICATION_JSON).build());
        }

    }

    public RequestParser(JsonObject payload) {
        if (payload.containsKey("meta") && payload.containsKey("data") && payload.getJsonObject("meta") != null && payload.getJsonObject("data") != null) {
            this.data = payload.getJsonObject("data");
            this.meta = payload.getJsonObject("meta");
        } else {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.buildBadRequest()).type(MediaType.APPLICATION_JSON).build());
        }

        if (!isValidSource(meta)) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(JB.buildBadRequest()).type(MediaType.APPLICATION_JSON).build());
        }

    }

    public JsonObject getData() {
        return data;
    }

    public JsonObject getMeta() {
        return meta;
    }

    private boolean isValidSource(JsonObject meta) {
        boolean response = false;
        if (meta.containsKey("source") && meta.getString("source") != null) {
            String source = meta.getString("source");
            if (source.equalsIgnoreCase("web") ) {
                response = true;
            }
        }
        return response;
    }

}
