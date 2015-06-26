package threadpool.simple;

import entity.XMLprice;
import jsonProcessing.json_simple.JsonSimpleParser;
import html.DataFromHTML;
import scaner.XMLpriceCollector;

import java.math.BigDecimal;

public class WorkerThread implements Runnable {
    private String artikul;

    public WorkerThread(String s) {
        this.artikul = s;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " Start. Command = " + artikul);
        processCommand();
//        System.out.println(Thread.currentThread().getName() + " End.");
    }

    private synchronized void processCommand() {
        try {
            Thread.sleep(100);

            String source = new DataFromHTML().getSourceStringDataByArtikul(artikul).toString();

            JsonSimpleParser jsonSimpleParser = new JsonSimpleParser();
            Integer productsQuantityAvailable = Integer.parseInt(jsonSimpleParser.getFromJSONvalueByKey(source, "productsQuantityAvailable").toString());
            if (productsQuantityAvailable > 0) {
                String nal = jsonSimpleParser.getFromJSONvalueByKey(source, "productsQuantityTotal").toString();
                String PosCode = jsonSimpleParser.getFromJSONvalueByKey(source, "eventProductId").toString();
                BigDecimal price1 = BigDecimal.valueOf(Double.parseDouble(jsonSimpleParser.getFromJSONvalueByKey(source, "eventProductPrice").toString()));

                BigDecimal priceUAH = price1.multiply(new BigDecimal(22)).setScale(2, BigDecimal.ROUND_HALF_UP); //------------------- KURS --------------------------

                XMLprice good = new XMLprice(2428L, artikul, price1, nal, PosCode, priceUAH);
                XMLpriceCollector.addToXMLPriceData(good);

//                System.out.println(artikul);
//                System.out.print(nal + " \t ");
//                System.out.print(PosCode + " \t ");
//                System.out.print(price1 + " \t ");
//                System.out.print(priceUAH + " \n");
                System.out.println(good);
            }
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString() {
        return this.artikul;
    }
}
