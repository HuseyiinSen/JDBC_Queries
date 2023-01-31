import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class jdbc_query_copy {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        1- ilgili driver'ı yükleyelim . MySQL kullandığımızı bildiriyoruz.
        Driver'ı bulamama ihtimaline karşı forName methodu için ClassNotFoundException'u method Signature'a
        fırlatıyoruz.


        */

        Class.forName("com.mysql.cj.jdbc.Driver");

        /*
        2- Bağlantıyı oluşturmak için "username ve password girişi" yapacağız.

         */

        Connection con= getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

        /* 3- SQL queryleri için bir Statement objesi oluşturup, javada SQL sorgularımız için bir alan oluşturacağız.

         */
        Statement st=con.createStatement();
        /*
        4- SQL querylerimizi yazıp, çalıştırabiliriz.
         */

        ResultSet data=st.executeQuery("SELECT * FROM personel");

       /*
       5-  SONUÇLARI GÖRMEK İÇİN Set içerisindeki elemanları while döngüsünde yazdırıyoruz.

        */


        while(data.next()){
            System.out.println(data.getString(1)+ " "+data.getString(2)+" "+ data.getInt(3));
        }
        /*
        6- oluşturulan bağlantıları kapatalım... con.close();
         */
        con.close();
        st.close();
        data.close();
    }
}


