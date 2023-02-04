import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class JDBC02EXECUTE_UPDATE {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

        /*======================================================================
        ORNEK1: ogrenciler tablosunu siliniz.
        ========================================================================*/
        /*String dropQuery="drop table isciler1";
        System.out.println(st.execute(dropQuery));*/

        /*=======================================================================
          ORNEK2: isciler adinda bir tablo olusturunuz id int,
          birim VARCHAR(10), maas int
        ========================================================================*/

        /* String createTable = "CREATE TABLE isciler1(id INT,birim VARCHAR(10),maas INT)";
        if (!st.execute(createTable)) {
            System.out.println("Isciler tablosu olusturuldu!");
        }
        /*=======================================================================
          ORNEK4: isciler tablosuna birden fazla yeni kayıt ekleyelim.
            INSERT INTO isciler VALUES(70, 'HR', 5000)
            INSERT INTO isciler VALUES(60, 'LAB', 3000)
            INSERT INTO isciler VALUES(50, 'ARGE', 4000)
         ========================================================================*/


        con.close();
        st.close();



    }
}
