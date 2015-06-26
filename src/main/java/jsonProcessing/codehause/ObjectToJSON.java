package jsonProcessing.codehause;

import jsonProcessing.ModelsJSON.RozetkaJSON_Model;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
// ------------------------------------
public class ObjectToJSON {
    public static void main(String[] args) {

        RozetkaJSON_Model sample = new RozetkaJSON_Model();
        System.out.println(sample);

        ObjectMapper mapper = new ObjectMapper();
        try {
            // convert user object to json string, and save to a file
            mapper.writeValue(new File("c:\\rozetka.json"), sample);
            // display to console
            System.out.println(mapper.writeValueAsString(sample));
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}