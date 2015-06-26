import dao.GoodsForScanDAO;
import dao.impl.GoodsForScanDAOImpl;
import dao.impl.XMLpriceDAOImpl;
import entity.GoodsForScan;
import entity.XMLprice;
import jsonProcessing.json_simple.JsonSimpleParser;
import html.DataFromHTML;

import java.io.FileWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<String> scanResultString;

    public static void main(String[] args) throws Exception {
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