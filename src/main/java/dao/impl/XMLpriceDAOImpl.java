package dao.impl;

import connector.DBConnector;
import dao.XMLpriceDAO;
import entity.GoodsForScan;
import entity.XMLprice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XMLpriceDAOImpl implements XMLpriceDAO {

    private DBConnector connector;
    private Connection connection;

    {
        connector = new DBConnector();
    }

    @Override
    public void create(XMLprice xmlPrice) throws SQLException {
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "INSERT INTO XMLPrice (klientID, Artikul, price1, price_UAH, nal, war, PosCode, Tip, priceRRP, " +
                "priceRRP_UAH, ddp, priceDiler) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, xmlPrice.getKlientID());
        statement.setString(2, xmlPrice.getArtikul());
        statement.setBigDecimal(3, xmlPrice.getPrice1());
        statement.setBigDecimal(4, xmlPrice.getPrice_UAH());
        statement.setString(5, xmlPrice.getNal());
        statement.setString(6, xmlPrice.getWar());
        statement.setString(7, xmlPrice.getPosCode());
        statement.setString(8, xmlPrice.getTip());
        statement.setBigDecimal(9, xmlPrice.getPriceRRP());
        statement.setBigDecimal(10, xmlPrice.getPriceRRP_UAH());
        statement.setBoolean(11, xmlPrice.getDdp());
        statement.setBigDecimal(12, xmlPrice.getPriceDiler());

        // Get results
        statement.executeUpdate();

        // Clear resources
        statement.close();
        connection.close();
    }

    @Override
    public XMLprice read(Long klientID) throws SQLException {
        XMLprice xmlPrice = null;
        if(klientID != null) {
            xmlPrice = new XMLprice();
            // Obtain connection
            connection = connector.getConnection();

            // Create SQL query
            String sql = "SELECT * FROM XMLPrice WHERE klientID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, klientID);

            // Get results
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                xmlPrice.setKlientID(resultSet.getLong("KlientID"));
                xmlPrice.setArtikul(resultSet.getString("Artikul"));
                xmlPrice.setPrice1(resultSet.getBigDecimal("price1"));
                xmlPrice.setPrice_UAH(resultSet.getBigDecimal("price_UAH"));
                xmlPrice.setNal(resultSet.getString("nal"));
                xmlPrice.setWar(resultSet.getString("war"));
                xmlPrice.setPosCode(resultSet.getString("PosCode"));
                xmlPrice.setTip(resultSet.getString("Tip"));
                xmlPrice.setPriceRRP(resultSet.getBigDecimal("priceRRP"));
                xmlPrice.setPriceRRP_UAH(resultSet.getBigDecimal("priceRRP_UAH"));
                xmlPrice.setDdp(resultSet.getBoolean("ddp"));
                xmlPrice.setPriceDiler(resultSet.getBigDecimal("priceDiler"));
            }

            // Clear resources
            resultSet.close();
            statement.close();
            connection.close();
        }
        return xmlPrice;
    }

    @Override
    public List<XMLprice> readAll() throws SQLException {
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "SELECT * FROM XMLPrice";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Get results
        List<XMLprice> list = new ArrayList<XMLprice>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            list.add(new XMLprice(
                    resultSet.getLong("II"),
                    resultSet.getLong("klientID"),
                    resultSet.getString("artikul"),
                    resultSet.getBigDecimal("price1"),
                    resultSet.getBigDecimal("price_UAH"),
                    resultSet.getString("nal"),
                    resultSet.getString("war"),
                    resultSet.getString("PosCode"),
                    resultSet.getString("Tip"),
                    resultSet.getBigDecimal("priceRRP"),
                    resultSet.getBigDecimal("priceRRP_UAH"),
                    resultSet.getBoolean("ddp"),
                    resultSet.getBigDecimal("priceDiler") ) );
        }

        // Clear resources
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }

    public List<XMLprice> readAllByKlientID(Long klientID) throws SQLException {
        List<XMLprice> list = null;
        if(klientID != null) {
            list = new ArrayList<XMLprice>();

            // Obtain connection
            connection = connector.getConnection();

            // Create SQL query
            String sql = "SELECT * FROM XMLPrice WHERE klientID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, klientID);

            // Get results
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new XMLprice(
                        resultSet.getLong("II"),
                        resultSet.getLong("klientID"),
                        resultSet.getString("artikul"),
                        resultSet.getBigDecimal("price1"),
                        resultSet.getBigDecimal("price_UAH"),
                        resultSet.getString("nal"),
                        resultSet.getString("war"),
                        resultSet.getString("PosCode"),
                        resultSet.getString("Tip"),
                        resultSet.getBigDecimal("priceRRP"),
                        resultSet.getBigDecimal("priceRRP_UAH"),
                        resultSet.getBoolean("ddp"),
                        resultSet.getBigDecimal("priceDiler")));
            }

            // Clear resources
            resultSet.close();
            statement.close();
            connection.close();
        }
        return list;
    }

    @Override
    public void update(XMLprice xmlPrice) throws SQLException {  //@TODO неправильно!
        if(xmlPrice != null && xmlPrice.getKlientID() != null) {
            // Obtain connection
            connection = connector.getConnection();

            // Create SQL query
            String sql = "UPDATE XMLPrice SET Artikul = ?, price1 = ?, price_UAH = ?, nal = ?, war = ?, PosCode = ?, Tip = ?," +
                    " priceRRP = ?, priceRRP_UAH = ?, ddp = ?, priceDiler = ? WHERE klientID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, xmlPrice.getArtikul());
            statement.setBigDecimal(2, xmlPrice.getPrice1());
            statement.setBigDecimal(3, xmlPrice.getPrice_UAH());
            statement.setString(4, xmlPrice.getNal());
            statement.setString(5, xmlPrice.getWar());
            statement.setString(6, xmlPrice.getPosCode());
            statement.setString(7, xmlPrice.getTip());
            statement.setBigDecimal(8, xmlPrice.getPriceRRP());
            statement.setBigDecimal(9, xmlPrice.getPriceRRP_UAH());
            statement.setBoolean(10, xmlPrice.getDdp());
            statement.setBigDecimal(11, xmlPrice.getPriceDiler());
            statement.setLong(12, xmlPrice.getKlientID());
            // Get results
            statement.executeUpdate();

            // Clear resources
            statement.close();
            connection.close();
        }
    }

    @Override
    public void delete(Long klientID) throws SQLException { //@TODO удалять по II !!!!!!!!!!!!
        if(klientID != null) {
            // Obtain connection
            connection = connector.getConnection();

            // Create SQL query
            String sql = "DELETE FROM XMLPrice WHERE klientID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, klientID);

            // Get results
            statement.executeUpdate();

            // Clear resources
            statement.close();
            connection.close();
        }
    }
}
