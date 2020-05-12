package util;


import constants.JsonConstant;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Ajitata & Lawal
 */
public class JB {
//JB.buildErrorRespone("403", "FORBIDDEN", "access denied").toJSONString()
    public static JsonObject buildISResponse() {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_500, JsonConstant.INTERNAL_SERVER_ERROR, JsonConstant.ERROR_OCCURED_WHILE_PROCESSING_YOUR_REQUEST));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }
    
    public static JsonObject notFoundResponse() {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_404, JsonConstant.NOT_FOUND, "No results found"));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }

    public static JsonObject invalidFormInput(JsonObject data) {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_406, JsonConstant.NOT_ACCEPTABLE, JsonConstant.INCOMPLETE_INPUT));
        js.add(JsonConstant.DATA, data);
        return js.build();
    }
    
    public static JsonObject buildBadRequest() {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_400, JsonConstant.BAD_REQUEST, JsonConstant.INVALID_REQUEST_BODY));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }
    
    public static JsonObject buildBadRequest(String message) {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_400, JsonConstant.BAD_REQUEST, message));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }
    
    public static JsonObject buildUnAuthorizerRequest() {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_401, JsonConstant.UNAUTHORIZED, JsonConstant.UNAUTHORIZED_ACCESS));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }
    
    public static JsonObject buildUnAuthorizerRequest(String message) {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_401, JsonConstant.UNAUTHORIZED, message));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }
    
    public static JsonObject buildForbiddenRequest() {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_403, JsonConstant.FORBIDDEN, JsonConstant.UNAUTHORIZED_ACCESS));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }

    public static JsonObject createOkResponse(JsonObject dataJSON) {
        JsonObjectBuilder response = Json.createObjectBuilder();
        response.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_200, JsonConstant.OK, JsonConstant.REQUEST_PROCESSED_SUCCESSFULLY));
        response.add(JsonConstant.DATA, dataJSON);
        return response.build();
    }
    
    public static JsonObject createOkResponse() {
        JsonObjectBuilder response = Json.createObjectBuilder();
        response.add(JsonConstant.META, buildMeta(JsonConstant.STATUS_200, JsonConstant.OK, JsonConstant.REQUEST_PROCESSED_SUCCESSFULLY));
        response.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return response.build();
    }

    public static JsonObject createResponse(JsonObject meta, JsonObject data) {
        JsonObjectBuilder response = Json.createObjectBuilder();
        response.add(JsonConstant.META, meta);
        response.add(JsonConstant.DATA, data);
        return response.build();
    }
    
    public static JsonObject createQuickResponse(String status, String message, String info) {
        JsonObjectBuilder response = Json.createObjectBuilder();
        response.add(JsonConstant.META, buildMeta(status, message, info));
        response.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return response.build();
    }

    public static JsonObject buildErrorResponse(String status, String message, String info) {
        JsonObjectBuilder js = Json.createObjectBuilder();
        js.add(JsonConstant.META, buildMeta(status, message, info));
        js.add(JsonConstant.DATA, Json.createObjectBuilder().build());
        return js.build();
    }

    public static JsonObject buildMeta(String status, String message, String info) {
        JsonObjectBuilder meta = Json.createObjectBuilder();
        meta.add(JsonConstant.STATUS, status);
        meta.add(JsonConstant.MESSAGE, message);
        meta.add(JsonConstant.INFO, info);
        return meta.build();
    }

}
