/*
* 1. Add MySQL database driver to classpath
* 2. Get Connection
* 3. Submit SQL query
* 4. Process result set
* */

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] arg){
        Connection connection = null;
        try{
            connection = ConnectionConfig.getConnection();
            if(connection != null)
            {
                System.out.println("Connection established");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
