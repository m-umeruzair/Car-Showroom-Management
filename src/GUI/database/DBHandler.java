package GUI.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Config {
    Connection dbconnection;
    public Connection getDbconnection() throws ClassNotFoundException, SQLException {

        String connection = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbconnection = DriverManager.getConnection(connection,dbUser,dbPassword);
        return dbconnection;
    }
}
