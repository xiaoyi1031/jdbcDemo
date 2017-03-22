import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class App_in {
    public static void main(String[] arg) {

        Connection myConn;
        CallableStatement myStmt;

        try {
            //get connection to database
            myConn = ConnectionConfig.getConnection();
            if (myConn != null) {
                System.out.println("Connection established");
            }
            String theDepartment = "Engineering";

            //prepare the stored procedure call: get_count_for_department(IN the_department VARCHAR(64), OUT the_count INT)
            myStmt = myConn.prepareCall("{call increase_salaries_for_department(?,?)}");

            //set Parameters
            myStmt.setString(1, theDepartment);
            myStmt.setDouble(2, 1000);

            //call stored procedured
            System.out.println("Calling stored procedure");
            myStmt.execute();
            System.out.print("Finished calling stored procudure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
