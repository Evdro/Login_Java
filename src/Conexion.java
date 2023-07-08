import java.sql.*;
/**
 *
 * @author EVDRO
 */
public class Conexion {
    Connection con;
    
    public Connection getConnection(){
        try {
            String myBD = "jdbc:mysql://localhost:3306/personas?serverTimezone=UTC";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
