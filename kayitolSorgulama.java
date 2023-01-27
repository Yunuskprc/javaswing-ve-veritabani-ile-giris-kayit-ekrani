import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class kayitolSorgulama {
    
    static boolean sonuc=false;
    static Connection conn;
    static int i=0;
    static String[] name = new String[100];

    public boolean ksorgulama(String kadi, String sifre, String sifreT,String Tc, String telNo) throws SQLException
    {

        if(sifre.equals(sifreT))
        {
            if(Tc.length()==11 && Tc.charAt(0)!='0')
            {
                if(telNo.length()==11 && telNo.charAt(0)=='0')
                {
                    sonuc=true;
                }
                else
                {
                    sonuc=false;
                }
            }
            else
            {
                sonuc=false;
            }
        }
        else
        {
            sonuc=false;
        }


        
        // hata sql ile kullanıcı adı sorgusunda

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uyeler","root", "Unutma23."); 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        Statement st = conn.createStatement();
        ResultSet rs=st.executeQuery("select * from kullanıcılar");
 
        while(rs.next())
        {
            name[i]=rs.getString("kullanıcıAdı");
            i++;
        }
        
        for(int j=0;j<i;j++)
        {
            if(kadi.equals(name[j]))
                sonuc=false;
        }   

        return sonuc;
    }


    public void kayitEkle(String kadi, String sifre)
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uyeler","root", "Unutma23.");
            Statement st = conn.createStatement();
            String sorgu = String.format("insert into kullanıcılar values( %d, '%s','%s')",i+2,kadi,sifre);
            int ekleme=st.executeUpdate(sorgu);
            i=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
