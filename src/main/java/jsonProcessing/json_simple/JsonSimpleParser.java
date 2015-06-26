package jsonProcessing.json_simple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;

public class JsonSimpleParser {
//    private static BufferedReader br;

    public synchronized Object getFromJSONvalueByKey(String sourceJSON_String, String jsonKeyString){
        if (sourceJSON_String != null && jsonKeyString != null) {
            Object result = null;
            JSONParser parser = new JSONParser();
//            br = new BufferedReader(new FileReader("c:\\file.json"));
            try {
                JSONObject jsonObj = (JSONObject) parser.parse(sourceJSON_String);
                if(jsonObj.get(jsonKeyString) !=null){
                    return jsonObj.get(jsonKeyString);
                }
//            System.out.println(jsonObj.get("searchImpressions"));
                JSONArray searchImpressions = (JSONArray) jsonObj.get("searchImpressions");
//                result = jsonObj.get(jsonKeyString).toString();
                if (searchImpressions != null) {
                    JSONObject obj1 = (JSONObject) searchImpressions.get(0);
//                    System.out.println(obj1.get(jsonKeyString));
                    result = obj1.get(jsonKeyString);
                }
            }catch (ParseException jp){
                jp.printStackTrace();
            }
            return result;
        } else {
            return null;
        }
    }
}

//            String source = "{\"pageType\":\"SearchResults\",\"searchType\":\"specific\",\"productsQuantityTotal\":\"2\",\"productsQuantityAvailable\":\"1\"," +
//                    "\"searchImpressions\":[{\"eventProductId\":1128405,\"test\":\"specific: model\",\"eventProductName\":\"Samsung Galaxy Tab S 8.4 16GB Titanium Bronze (SM-T700NTSASEK)\"," +
//                    "\"eventProductPrice\":418.55813953488,\"eventProductVendorName\":\"samsung\",\"eventCategoryName\":\"\\u041f\\u043b\\u0430\\u043d\\u0448\\u0435\\u0442\\u044b\"," +
//                    "\"eventList\":\"Search Impressions\",\"eventPosition\":1}," +
//                    "{\"eventProductId\":1279640,\"test\":\"specific: model\"," +
//                    "\"eventProductName\":\"Samsung UE65HU8700+ \\u041f\\u043b\\u0430\\u043d\\u0448\\u0435\\u0442 Samsung Galaxy Tab S 8.4 16GB Titanium Bronze (SM-T700NTSASEK)\"," +
//                    "\"eventProductPrice\":3651.1162790698,\"eventProductVendorName\":\"samsung\",\"eventCategoryName\":\"\\u0422\\u0435\\u043b\\u0435\\u0432\\u0438\\u0437\\u043e\\u0440\\u044b\"," +
//                    "\"eventList\":\"Search Impressions\",\"eventPosition\":2}]}";

