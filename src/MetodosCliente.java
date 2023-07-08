
import java.sql.*;
import javax.swing.JOptionPane;

public class MetodosCliente {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Boolean RegistrarCliente(Cliente cl) {
        String sql = "insert into usuarios(usuario,pass) values (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getUsuario());
            ps.setString(2, cl.getPassword());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
