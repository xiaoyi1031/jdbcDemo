import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class App_out {
    public static void main(String[] arg){

        Connection myConn;
        CallableStatement myStmt;

        try{
            //get connection to database
            myConn = ConnectionConfig.getConnection();
            String theDepartment = "Engineering";

            //prepare the stored procedure call: get_count_for_department(IN the_department VARCHAR(64), OUT the_count INT)
            myStmt = myConn.prepareCall("{call get_count_for_department(?,?)}");

            //set Parameters
            myStmt.setString(1,"Engineering");
            myStmt.registerOutParameter(2, Types.INTEGER);

            //call stored procedured
            System.out.println("Calling stored procedure");
            myStmt.execute();
            int theCount = myStmt.getInt(2);
            System.out.println("The count =" + theCount);
            System.out.print("Finished calling stored procudure");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
