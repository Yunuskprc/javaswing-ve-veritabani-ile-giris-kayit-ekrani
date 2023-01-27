import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GirisSorgulama {
    
    static  Connection conn;
    static boolean sonuç=false;

    public boolean sorgulama(String kadi, String sifre) throws SQLException
    {
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uyeler","root", "Unutma23."); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery("select * from kullanıcılar");

        while(rs.next())
        {
            if(kadi.equals(rs.getString("kullanıcıAdı")))
            {
                if(sifre.equals(rs.getString("şifre")))
                {
                    sonuç=true;
                }
            }
        }

        return sonuç;
    }

}
