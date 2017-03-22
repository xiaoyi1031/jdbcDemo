import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

public class App_ResultSet {
    public static void main(String[] arg) {

        Connection myConn;
        CallableStatement myStmt;
        ResultSet myRs;

        try {
            //get connection to database
            myConn = ConnectionConfig.getConnection();
            String theDepartment = "Engineering";

            //prepare the stored procedure call,//procedure 'get_employee_for_department'(IN the_department VARCHAR(64))
            myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");

            //set Parameters
            myStmt.setString(1, theDepartment);

            //call stored procedured
            System.out.println("Calling stored procedure");
            myStmt.execute();

            //get the result set
            myRs = myStmt.getResultSet();

            if (myRs != null) {
                System.out.println("here");
            }

            System.out.print("Finished calling stored procudure");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
