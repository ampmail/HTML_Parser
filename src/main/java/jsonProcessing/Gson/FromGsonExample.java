package jsonProcessing.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import jsonProcessing.ModelsJSON.RozetkaJSON_Model;

public class FromGsonExample {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("c:\\file2.json"));
            //convert the json string back to object
            System.out.println(gson.fromJson(br, RozetkaJSON_Model.class));
//            RozetkaJSON_Model obj = gson.fromJson(br, RozetkaJSON_Model.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}