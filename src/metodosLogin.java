import java.sql.*;
import java.util.HashSet;

public class metodosLogin {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String usuario, String pass){
        login l = new login();
        String sql = "select * from usuarios where usuario = ? and pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareCall(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id"));
                l.setUsuario(rs.getString("usuario"));
                l.setPassword(rs.getString("pass"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
