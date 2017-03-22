/*
* 1. Add MySQL database driver to classpath
* 2. Get Connection
* 3. Submit SQL query
* 4. Process result set
* https://www.youtube.com/watch?v=MtIYkYcsoJY&list=PLEAQNNR8IlB4R7NfqBY1frapYo97L6fOQ&index=8
* */

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] arg) {
        Connection connection = null;
        try {
            connection = ConnectionConfig.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
