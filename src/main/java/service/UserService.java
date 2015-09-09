//package service;
//
//import dao.GoodsForScanDAO;
//import dao.impl.GoodsForScanDAOImpl;
//import entity.GoodsForScan;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserService {
//
//    public static void main(String[] args) throws SQLException {
//        GoodsForScan user = new GoodsForScan();
//        user.setКодТовара(19l);
//        user.setКодТипа("Jim");
//        user.setArtikul(34);
//
//        GoodsForScanDAO userDAO = new GoodsForScanDAOImpl();
//        userDAO.create(user);
//
//        System.out.println(userDAO.read(18l));
//        System.out.println("-----");
//
//        List<GoodsForScan> list = userDAO.readAll();
//        for (GoodsForScan user1 : list) {
//            System.out.println(user1);
//        }
//        System.out.println("-----");
//
//        user.setКодТипа("Bob");
//        userDAO.update(user);
//
//        System.out.println(userDAO.read(19l));
//        System.out.println("-----");
//
//        userDAO.delete(19l);
//
//        list = userDAO.readAll();
//        for (GoodsForScan user1 : list) {
//            System.out.println(user1);
//        }
//        System.out.println("-----");
//    }
//}

/*

Lenovo IdeaPad G50-30 (80G00181UA)
1S80G00181UAPF066ZK0
1S80G00181UAPF05UQYL
1S80G00181UAPF05UQY2
1S80G00181UAPF06712R
1S80G00181UAPF05USWF
1S80G00181UAPF066ZD3
1S80G00181UAPF0670Y3
1S80G00181UAPF05UT3S
1S80G00181UAPF066Z2B

Lenovo IdeaPad G50-70 (59-424948)
1s59424948yb04939672
1s59424948yb04192062
1s59424948yb04934457
1s59424948yb04934235
1s59424948yB04189729
1s59424948yb04942085
1s59424948yb04939087
1s59424948yb04941628
1s59424948yb04939321
1s59424948yb04934940




*/