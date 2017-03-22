import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class App_inout {
    public static void main(String[] arg) {

        Connection myConn;
        CallableStatement myStmt;

        try {
            //get connection to database
            myConn = ConnectionConfig.getConnection();
            String theDepartment = "Engineering";

            //prepare the stored procedure call
            myStmt = myConn.prepareCall("{call greet_the_department(?)}");

            //set Parameters
            myStmt.registerOutParameter(1, Types.VARCHAR);
            myStmt.setString(1, theDepartment);

            //call stored procedured
            System.out.println("Calling stored procedure");
            myStmt.execute();
            System.out.print("Finished calling stored procudure");

            String theResult = myStmt.getString(1);
            System.out.println("The result is : " + theResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
