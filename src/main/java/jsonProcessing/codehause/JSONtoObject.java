package jsonProcessing.codehause;

import java.io.File;
import java.io.IOException;

import jsonProcessing.ModelsJSON.RozetkaJSON_Model;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONtoObject {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // read from file, convert it to user class
            RozetkaJSON_Model user = mapper.readValue(new File("c:\\file.json"), RozetkaJSON_Model.class);
            // display to console
            System.out.println(user);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}