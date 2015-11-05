import com.google.gson.Gson;
import dao.GoodsForScanDAO;
import dao.impl.GoodsForScanDAOImpl;
import dao.impl.XMLpriceDAOImpl;
import entity.GoodsForScan;
import entity.XMLprice;
import jsonProcessing.json_simple.JsonSimpleParser;
import html.DataFromHTML;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    private static List<String> scanResultString;

    public static void main(String[] args) throws Exception {

        Document doc = null;
        int status = 0;
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("key_1", "Baku");
//        map.put("key_2", "Azerbaijan");
//        map.put("key_3", "Ali Mamedov");
//        Gson gson = new Gson();
//        System.out.println(gson.toJson(map));

        try {
            String url = "http://www.it-link.ua/Home/SaveGrpSet";

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
//            conn.setReadTimeout(2000);
            conn.addRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
            conn.addRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.addRequestProperty("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4,uk;q=0.2");
            conn.addRequestProperty("Connection", "keep-alive");
            conn.addRequestProperty("Content-Length", "1000");
            conn.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            conn.addRequestProperty("User-Agent", "Mozilla");
            conn.addRequestProperty("Host", "www.it-link.ua");
            conn.addRequestProperty("Origin", "http://www.it-link.ua");
            conn.addRequestProperty("Referer", "http://www.it-link.ua/Home");
            conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36");
            conn.addRequestProperty("X-FirePHP-Version", "0.0.6");
            conn.addRequestProperty("X-Requested-With", "XMLHttpRequest");
            conn.setDoOutput(true);

//            OutputStreamWriter w = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");

            String jsonReq = "{\"CatalogId\":\"     A135\",\"Groups\":[],\"Columns\":[{\"Name\":\"Code\",\"Alias\":\"Code\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Qty\",\"Alias\":\"Qty\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Price\",\"Alias\":\"Price\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Model\",\"Alias\":\"Model\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Article\",\"Alias\":\"Article\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Name\",\"Alias\":\"Product name\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Measure\",\"Alias\":\"Meas\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Group\",\"Alias\":\"Group\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Vendor\",\"Alias\":\"Vendor\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Guar\",\"Alias\":\"Guar\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Availability\",\"Alias\":\"Availability\",\"Disabled\":false,\"Required\":true}],\"Formats\":[{\"Name\":\"HTML\",\"Checked\":false},{\"Name\":\"XLS\",\"Checked\":false},{\"Name\":\"XML\",\"Checked\":true},{\"Name\":\"PDF\",\"Checked\":false}],\"Order\":\"BASEPRICE\",\"Direct\":\"DESC\",\"PageSize\":\"12\",\"View\":\"2\"}";
//            w.write(jsonReq);
//            w.close();

//            System.out.println("Request URL: " + url);
//            status = conn.getResponseCode();
//            System.out.println("Response Code " + status);

//            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String inputLine;
//            StringBuffer html = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                html.append(inputLine);
//            }
//            in.close();
//            conn.disconnect();
//            System.out.println("URL Content... \n" + html.toString());
//            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }


        String url = "http://www.it-link.ua/Home/SaveGrpSet";
        try {
//            response = Jsoup.connect(url).timeout(3000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36").post();
            Connection conn = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36").referrer("http://www.it-link.ua/Home").maxBodySize(0).timeout(3000);
//            Map<String,String> myMap= new HashMap <String, String>();
//            myMap.put("method", "Catalog.search");
//            myMap.put("pag", "1");
//            myMap.put("business_url", "electrodomesticos");
//            myMap.put("category_url", "climatizacion" );
//            myMap.put("subcategory_url", "" );
//            myMap.put("valmin", "-1" );
//            myMap.put("valmax", "-1");
            String jsonReq = "{\"CatalogId\":\"     A135\",\"Groups\":[],\"Columns\":[{\"Name\":\"Code\",\"Alias\":\"Code\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Qty\",\"Alias\":\"Qty\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Price\",\"Alias\":\"Price\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Model\",\"Alias\":\"Model\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Article\",\"Alias\":\"Article\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Name\",\"Alias\":\"Product name\",\"Disabled\":false,\"Required\":true},{\"Name\":\"Measure\",\"Alias\":\"Meas\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Group\",\"Alias\":\"Group\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Vendor\",\"Alias\":\"Vendor\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Guar\",\"Alias\":\"Guar\",\"Disabled\":false,\"Required\":false},{\"Name\":\"Availability\",\"Alias\":\"Availability\",\"Disabled\":false,\"Required\":true}],\"Formats\":[{\"Name\":\"HTML\",\"Checked\":false},{\"Name\":\"XLS\",\"Checked\":false},{\"Name\":\"XML\",\"Checked\":true},{\"Name\":\"PDF\",\"Checked\":false}],\"Order\":\"BASEPRICE\",\"Direct\":\"DESC\",\"PageSize\":\"12\",\"View\":\"2\"}";
            conn.data(jsonReq);
            conn.post();
            Connection.Response respon = conn.execute();
            System.out.println(respon.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        if(status == 200) {
            try {
                doc = Jsoup.connect("http://www.it-link.ua/Home/pricelist?id=%20%20%20%20%20A135").timeout(3000).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.71 Safari/537.36").get();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            if (doc != null) {
                if (doc.getElementsByTag("tbody") != null) {
                    System.out.println(doc.body());

                    List table = doc.body().getElementsByTag("tr");
                    for (Object t : table) {
                        System.out.println(t);
                        break;
                    }
                }
            }
        }
/*
        scanResultString = new LinkedList<>();

        Thread newThread = new Thread(new Runnable() {
            public void run() {
                DataFromHTML rozetka = new DataFromHTML();
                scanResultString.add(rozetka.getSourceStringDataByArtikul("wd40ezrx").toString());
                System.out.println("run(): " + Thread.currentThread().getName());
            }
        });
        newThread.start();

        while (newThread.isAlive()){
        }

        for (String source : scanResultString){

            JsonSimpleParser jsonSimpleParser = new JsonSimpleParser();
            Object result1, result2, result3;
            String key = "productsQuantityAvailable";
            result1 = jsonSimpleParser.getFromJSONvalueByKey(source, key);
            key = "eventProductId";
            result2 = jsonSimpleParser.getFromJSONvalueByKey(source, key);
            key = "eventProductPrice";
            result3 = jsonSimpleParser.getFromJSONvalueByKey(source, key);
            System.out.println(result2 + " " + result1 + " = " + result3);
        }
        System.exit(0);
*/
/*      JAXB TEST
        Product product0 = new Product(19512, "ADX2450CK23GM", 1, "Socket AM3",
                "Athlon 64 II X2 245 (Socket AM3) tray", "AMD", 0, 1, "*****",
                new BigDecimal(100), new BigDecimal(1095), 11);
        Product product1 = new Product(19516, "ADY2450CK23GM", 1, "Socket AM4",
                "Athlon 64 II X4 445 (Socket AM4) tray", "AMD", 2, 1, "-",
                new BigDecimal(2200), new BigDecimal(50095), 48);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product0);
        productList.add(product1);

        Pricelist pricelist = new Pricelist();
        pricelist.setName("price from 01.06.2015");
        for (Product prod : productList) {
            try {
                pricelist.getProducts().add(prod);
            } catch (Exception exception) {
                Logger.getLogger(Main.class.getName()).log(Level.ALL, "createJavaObjectExample1 threw ParseException", exception);
            }
        }
*/
/*
        parser = new JaxbParser();
        file = new File("d:\\Git\\ScriptServer\\tmp\\statement.xml");

        Euro getpricelist = null;
        try {
            getpricelist = (Euro) parser.getObject(file, Euro.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(getpricelist.toString());
*/

//        convertProductToXml(pricelist);

/*
        int i=0, j=0;
        List<GoodsForScan> goods;
        goods = getAllGoodsForScanFromDB();
        FileWriter file = new FileWriter("c:\\goods.txt");
        System.out.println("-- List of all goods --");
        for (GoodsForScan good : goods) {
            j++;
            file.write(good.getArtikul().toString() + ", ");
//            System.out.print((good.getArtikul().toString().indexOf("http") >= 0) ? ("" + i++ +" ("+j+") "+ good + "\n") : (""));
            System.out.print(good.getArtikul().toString() + ", ");
        }
        file.flush();
        file.close();

        System.out.println();
        System.out.println("url qty " + i);
        System.out.println("Total goods qty " + j);
*/
/*
        List<XMLprice> xmlPrice;
        Long klientID = 5519L;
        xmlPrice = getAllXMLpriceByKlientID(klientID);
        System.out.println("-- List of all price by klientID" + klientID +" --");
        for (XMLprice price : xmlPrice) {
            System.out.println(price);
        }
*/
    }

    private static List<GoodsForScan> getAllGoodsForScanFromDB() {
        GoodsForScanDAO goodsDAO = new GoodsForScanDAOImpl();
        List<GoodsForScan> goods = new ArrayList<GoodsForScan>();
        try {
            goods = goodsDAO.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    private static List<XMLprice> getAllXMLpriceByKlientID(Long klientId) {
        XMLpriceDAOImpl xmLpriceDAO = new XMLpriceDAOImpl();
        List<XMLprice> xmLprice = new ArrayList<XMLprice>();
        try {
            xmLprice = xmLpriceDAO.readAllByKlientID(klientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xmLprice;
    }
}