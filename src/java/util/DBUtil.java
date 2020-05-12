package util;

import dao.PersonDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lawal
 */
public class DBUtil {

    private static final DBUtil DB_UTIL = new DBUtil();

    private Connection connection;

    private DBUtil() {
    }

    public static DBUtil getInstanceOfDBUtil() {
        return DB_UTIL;
    }

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb?useSSL=false&maxReconnects=3&serverTimezone=UTC", "payroll", "payroll");

        return connection;
    }

}
