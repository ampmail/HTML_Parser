package dao.impl;

import connector.DBConnector;
import dao.GoodsForScanDAO;
import entity.GoodsForScan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsForScanDAOImpl implements GoodsForScanDAO {

    private DBConnector connector;
    private Connection connection;

    {
        connector = new DBConnector();
    }

    @Override
    public void create(GoodsForScan goodsForScan) throws SQLException {
        return;
        /*
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "INSERT INTO GoodsForScanNew (КодТовара, КодТипа, artikul) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, goodsForScan.getКодТовара());
        statement.setLong(2, goodsForScan.getКодТипа());
        statement.setString(3, goodsForScan.getArtikul());

        // Get results
        statement.executeUpdate();

        // Clear resources
        statement.close();
        connection.close();
        */
    }

    @Override
    public GoodsForScan read(Long КодТовара) throws SQLException {
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "SELECT * FROM GoodsForScan WHERE КодТовара = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, КодТовара);

        // Get results
        GoodsForScan goodsForScan = new GoodsForScan();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            goodsForScan.setКодТовара(resultSet.getLong("КодТовара"));
            goodsForScan.setКодТипа(resultSet.getInt("КодТипа"));
            goodsForScan.setArtikul(resultSet.getString("artikul"));
        }

        // Clear resources
        resultSet.close();
        statement.close();
        connection.close();
        return goodsForScan;
    }

    @Override
    public List<GoodsForScan> readAll() throws SQLException {
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "SELECT * FROM GoodsForScan";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Get results
        List<GoodsForScan> list = new ArrayList<GoodsForScan>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            list.add(new GoodsForScan(resultSet.getLong("КодТовара"),
                    resultSet.getInt("КодТипа"),
                    resultSet.getString("artikul")));
        }

        // Clear resources
        resultSet.close();
        statement.close();
        connection.close();
        return list;
    }

    @Override
    public void update(GoodsForScan goodsForScan) throws SQLException {
        return;
        /*
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "UPDATE GoodsForScanNew SET КодТипа = ?, artikul = ? WHERE КодТовара = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, goodsForScan.getКодТипа());
        statement.setString(2, goodsForScan.getArtikul());
        statement.setLong(3, goodsForScan.getКодТовара());

        // Get results
        statement.executeUpdate();

        // Clear resources
        statement.close();
        connection.close();
        */
    }

    @Override
    public void delete(Long КодТовара) throws SQLException {
        return;
        /*
        // Obtain connection
        connection = connector.getConnection();

        // Create SQL query
        String sql = "DELETE FROM GoodsForScanNew WHERE КодТовара = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, КодТовара);

        // Get results
        statement.executeUpdate();

        // Clear resources
        statement.close();
        connection.close();
        */
    }
}
