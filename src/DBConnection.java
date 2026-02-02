import java.sql.*;
public class DBConnection {
    private static final String url ="jdbc:mysql://localhost:3306/busticketing_db";
    private static final String username ="root";
    private static final String password ="Atharv@568";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
