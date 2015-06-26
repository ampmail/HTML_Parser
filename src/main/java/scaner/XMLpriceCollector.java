package scaner;

import entity.XMLprice;

import java.util.ArrayList;
import java.util.List;

public class XMLpriceCollector {
    private Long klientID;
    private static List<XMLprice> list = new ArrayList<XMLprice>();

    public static synchronized boolean addToXMLPriceData(XMLprice xmlPrice){

        list.add(xmlPrice);
        return true;
    }

    public static List<XMLprice> getList() {
        return list;
    }

    public static void storeToDB(){

    }
}
