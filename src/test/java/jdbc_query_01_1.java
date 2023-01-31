import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class jdbc_query_01_1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st=con.createStatement();
        /*=======================================================================
        ORNEK1: Id'si 1'den buyuk firmalarin ismini ve iletisim_isim'ini isim
        ters sirali yazdirin.
        ========================================================================*/
        /*
        CREATE TABLE firmalar
        (
        id INT,
        isim VARCHAR(20),
        iletisim_isim VARCHAR(20),
        CONSTRAINT firmalar_pk PRIMARY KEY (id, isim)
        );

        INSERT INTO firmalar VALUES
        (1, 'ACB', 'Ali Can'),
        (2, 'RDB', 'Veli Gul'),
        (3, 'KMN', 'Ayse Gulmez');
         */
        System.out.println("====================2. örnek===========================");

        String selectquery="select isim, iletisim_isim " +
                            "from firmalar " +
                            "where id>1 " +
                            "order by isim desc";
       ResultSet data=st.executeQuery(selectquery);

       while (data.next()){
           System.out.println(  data.getString("isim")+" "+
                                data.getString("iletisim_isim"));
       }
        System.out.println("====================2. örnek===========================");

        String selectQuery3 = "SELECT id, isim " +
                                "FROM firmalar " +
                                "WHERE iletisim_isim LIKE '%li%' " +
                                "ORDER BY id";
        ResultSet data2 = st.executeQuery(selectQuery3);
        while(data2.next()){
            System.out.println(data2.getInt("id") + " " +
                    data2.getString("isim"));
        }

             /*
            A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
               dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
                1) execute() metodu
                2) executeUpdate() metodu.

            B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
               - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
                 DML islemlerinde true deger dondurur.
               - Ozellikle, hangi tip SQL ifadesine hangi metodun uygun olduğunun bilinemediği
                 durumlarda tercih edilmektedir.

            C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
               - bu islemlerde islemden etkilenen satir sayisini dondurur.
               - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
                */
        con.close();
        st.close();
        data.close();
        data2.close();
    }
}
