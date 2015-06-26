package html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import sun.net.www.protocol.https.DefaultHostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class DataFromHTML {

    public synchronized StringBuffer getSourceStringDataByArtikul(String artikul) {
        Document doc = null;
        try {
            System.setProperty("http.proxyHost", "178.165.15.40");
            System.setProperty("http.proxyPort", "3128");
            doc = Jsoup.connect("http://rozetka.com.ua/search/?section=%2F&text=" + URLEncoder.encode(artikul, "UTF-8")).timeout(5000).userAgent("Mozilla/17.0").get();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        if (doc != null) {
            Element link = doc.select("body").first();
            StringBuffer sourceHeap = new StringBuffer();
            sourceHeap.append(link.getElementsByTag("script"));
            int cutIndexFrom = sourceHeap.indexOf("{\"pageType\":\"");
            return new StringBuffer(sourceHeap.substring(cutIndexFrom, sourceHeap.indexOf("</script>", cutIndexFrom) - 4));
        }
        return null;
    }

    public StringBuffer getDataFromUrl(String source) throws Exception {

        StringBuffer inputLine = new StringBuffer("");

        URL myurl = new URL(source);
        HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
        con.setHostnameVerifier(new DefaultHostnameVerifier());
        InputStream ins = con.getInputStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader in = new BufferedReader(isr);

        String inLine;
        while ((inLine = in.readLine()) != null)
        {
            inputLine.append(inLine);
            System.out.println(inputLine);
        }
        in.close();
        return inputLine;
    }

}

//    private Document getDocumentFromURL(String url) {
//        Document doc = new Document(url);
//        try {
//            doc = Jsoup.connect(url).get();
////                    .data("query", "Java")
////                    .userAgent("Mozilla")
////                    .cookie("auth", "token")
////                    .timeout(3000)
////                    .post();
//        } catch (IOException e) {
//            System.out.print(e);
//        }
//        return doc;
//    }

//        <div class="g-price-uah">4 048<span class="g-price-uah-sign"> грн.</span></div>

//        <div class="g-price-uah">
//                3 970
//                <span class="g-price-uah-sign"> грн.</span>
//        </div>

//        dataLayer.push({"pageType":"SearchResults","searchType":"specific","productsQuantityTotal":"1","productsQuantityAvailable":"1","searchImpressions":[{"eventProductId":318126,"test":"specific: model","eventProductName":"Western Digital Green 4TB 5400rpm 64MB WD40EZRX 3.5 SATA III","eventProductPrice":176.44444444444,"eventProductVendorName":"western-digital","eventCategoryName":"\u0416\u0435\u0441\u0442\u043a\u0438\u0435 \u0434\u0438\u0441\u043a\u0438","eventList":"Search Impressions","eventPosition":1}]});

//        GTMEventsData.setGoodsData(
//                318126,
//                {
//                        id: 318126,
//                title:'Western Digital Green 4TB 5400rpm 64MB WD40EZRX 3.5 SATA III',
//                parent_id:80084,
//                parent:'Жесткие диски',
//                producer_id:70,
//                producer:'Western Digital',
//                price_usd:'176',
//                rank:1,
//                type:'specific',
//                part:'model',
//                search_text:'wd40ezrx',
//                top_parent_id:80026
//        }

//        <div class="g-i-status unavailable">
//                Нет в наличии

//        System.out.println(link.html());
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(link.getElementsByClass("g-i-status"));
//        System.out.println("--------------------------------------------------------------------");
//        System.out.println(link.getElementsByTag("script"));
//        System.out.println("--------------------------------------------------------------------");
