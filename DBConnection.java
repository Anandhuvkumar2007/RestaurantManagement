import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/restaurant_db";
    static String username = "root";
    static String password = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}