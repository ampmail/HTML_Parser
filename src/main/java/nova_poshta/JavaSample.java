package nova_poshta;
// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JavaSample {
    public static void main(String[] args) {
        HttpClient httpclient = HttpClients.createDefault();

        try {
            URIBuilder builder = new URIBuilder("http://testapi.novaposhta.ua/v2.0/en/JSON/getDocumentList/");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request body
            String body =
//                    "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                    "<root>\n" +
//                    "<apiKey>5f429b6381ccc0b1e6a70e6398792a6</apiKey>\n" +
//                    " <modelName>InternetDocument</modelName>\n" +
//                    " <calledMethod>getDocumentList</calledMethod>\n" +
//                    " <methodProperties>\n" +
//                    " <DateTime>24.09.2015</DateTime>\n" +
//                    " </methodProperties>\n" +
//                    "</root>";
                    "{" +
                    "\"apiKey\": \"[5f429b6381ccc0b1e6a70e6398792a6]\"," +
                    " \"modelName\": \"InternetDocument\"," +
                    " \"calledMethod\": \"getDocumentList\"," +
                    " \"methodProperties\": {" +
                    " \"DateTime\": \"24.09.2015\"" +
                    "}}";
            StringEntity reqEntity = new StringEntity(body);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}