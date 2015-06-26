package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnector {

    private java.sql.Connection con;

    public Connection getConnection() { //throws SQLException, ClassNotFoundException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("db");

            Class.forName(rb.getString("db.ClassForName"));

            String connectionString = new StringBuffer("")
                    .append(rb.getString("db.jdbc"))
                    .append(rb.getString("db.host"))
                    .append('\\')
                    .append(rb.getString("db.serverName"))
                    .append(":")
                    .append(rb.getString("db.port"))
                    .append(";databaseName=")
                    .append(rb.getString("db.name"))
                    .append(";selectMethod=")
                    .append(rb.getString("db.selectMethod"))
                    .append(";")
                    .toString();

            con = DriverManager.getConnection(connectionString, rb.getString("db.user"), rb.getString("db.password"));
//            if (con != null) System.out.println("Connection Successful!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
