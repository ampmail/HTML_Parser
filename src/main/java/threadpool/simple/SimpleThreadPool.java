package threadpool.simple;

import entity.XMLprice;
import scaner.GoodsScaner;
import scaner.XMLpriceCollector;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        GoodsScaner gs = new GoodsScaner();
        String artikul;
        while (gs.hasNextElement()){
            artikul = gs.getNextGoods();
//            artikul = "KX-TS2352UAW";
            if (artikul != null) {
                Runnable worker = new WorkerThread(artikul);
                executor.execute(worker);
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(1000L);
        }
        System.out.println("Finished all threads");

        List<XMLprice> xmlPrice = XMLpriceCollector.getList();
//        Long klientID = 5519L;
        for (XMLprice price : xmlPrice) {
            System.out.println(price);
        }
    }
}