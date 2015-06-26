package threadpool.simple;

import entity.XMLprice;
import scaner.GoodsScaner;
import scaner.XMLpriceCollector;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(6);
        GoodsScaner gs = new GoodsScaner();
        String artikul;
        while (gs.hasNextElement()){
            artikul = gs.getNextGoods();
            if (artikul != null) {
                Runnable worker = new WorkerThread(artikul);
                executor.execute(worker);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");

        List<XMLprice> xmlPrice = XMLpriceCollector.getList();
//        Long klientID = 5519L;
        for (XMLprice price : xmlPrice) {
            System.out.println(price);
        }
    }
}