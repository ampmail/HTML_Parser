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
