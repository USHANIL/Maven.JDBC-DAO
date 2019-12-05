package daos;


import com.mysql.cj.jdbc.Driver;

//import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDatabase {
    public static final String URL = "jdbc:mysql://localhost:3306/myNewDB";
    public static final String USER = "root";
    public static final String PASS = "Anish@2016";

    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASS);
            properties.setProperty("useSSL", "false");
            Connection conn = DriverManager.getConnection(URL, properties);
            return conn;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
