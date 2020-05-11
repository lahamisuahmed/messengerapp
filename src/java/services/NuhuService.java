package services;

import dao.PersonDao;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

/**
 *
 * @author Lawal
 */
public class NuhuService {
    
    public JsonObject getPersons() {
        PersonDao personDao = new PersonDao();
        
        JsonArrayBuilder array = Json.createArrayBuilder();
        personDao.persons().stream().map((person) -> Json.createObjectBuilder().add("dob", person.getDob()).add("height", person.getHeight()).add("id", person.getId()).add("name", person.getName()).add("age", person.getAge()).add("salary", person.getSalary()).build()).forEachOrdered((personJson) -> {
            array.add(personJson);
        });

        return Json.createObjectBuilder().add("persons", array.build()).build();
       
    }

    public JsonObject putJson(JsonObject object) {
        return object;
    }

    public JsonObject delete(JsonObject object) {
        return object;
    }

    public JsonObject post(JsonObject object) {
        return object;
    }
}
