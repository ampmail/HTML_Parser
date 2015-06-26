package jsonProcessing.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import jsonProcessing.ModelsJSON.RozetkaJSON_Model;

public class GsonExample {
    public static void main(String[] args) {

        RozetkaJSON_Model obj = new RozetkaJSON_Model(
                "SearchResults",
                "specific",
                "1",
                "1",
                new ArrayList<Object>());

        Map data = new LinkedHashMap<Object, Object>();
        data.put("eventProductId", 318126);
        data.put("test", "specific: model");
        data.put("eventProductName", "Western Digital Green 4TB 5400rpm 64MB WD40EZRX 3.5 SATA III");
        data.put("eventProductPrice", 176.44444f);
        data.put("eventProductVendorName", "western-digital");
        data.put("eventCategoryName", "\u0416\u0435\u0441\u0442\u043a\u0438\u0435 \u0434\u0438\u0441\u043a\u0438");
        data.put("eventList", "Search Impressions");
        data.put("eventPosition", 1);
        obj.searchImpressions.add(data);

        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(obj);

        try {
            //write converted json data to a file named "file.json"
            FileWriter writer = new FileWriter("c:\\file.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);

    }
}