package scaner;

import dao.GoodsForScanDAO;
import dao.impl.GoodsForScanDAOImpl;
import entity.GoodsForScan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsScaner {

    private static List<GoodsForScan> allGoods = new ArrayList<GoodsForScan>();
    private static Integer goodsCount;
    private static Integer pointer = 0;

    {
        allGoods = getAllGoodsForScanFromDB();
        goodsCount = allGoods.size();
    }

    public GoodsScaner() {
    }

    public synchronized Boolean hasNextElement() {
        return pointer < goodsCount;
    }

    public synchronized String getNextGoods() {
        if (this.hasNextElement()) {
            return allGoods.get(pointer++).getArtikul();
        }
        return null;
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

}
