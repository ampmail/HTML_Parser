package jsonProcessing.JSON.simple;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jsonProcessing.ModelsJSON.RozetkaJSON_Model;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleExample {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
//        obj.put("name", "mkyong.com");
//        obj.put("age", new Integer(100));
//
//        JSONArray list = new JSONArray();
//        list.add("msg 1");
//        list.add("msg 2");
//        list.add("msg 3");
//
//        obj.put("messages", list);

        RozetkaJSON_Model roz = new RozetkaJSON_Model(
                "SearchResults",
                "specific",
                "1",
                "1",
                new ArrayList<Object>());

        Map data = new HashMap<Object, Object>();
        data.put("eventProductId", 318126);
        data.put("test", "specific: model");
        data.put("eventProductName", "Western Digital Green 4TB 5400rpm 64MB WD40EZRX 3.5 SATA III");
        data.put("eventProductPrice", 176.44444444444f);
        data.put("eventProductVendorName", "western-digital");
        data.put("eventCategoryName", "\u0416\u0435\u0441\u0442\u043a\u0438\u0435 \u0434\u0438\u0441\u043a\u0438");
        data.put("eventList", "Search Impressions");
        data.put("eventPosition", 1);
        roz.searchImpressions.add(data);

        try {

            FileWriter file = new FileWriter("c:\\test.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}