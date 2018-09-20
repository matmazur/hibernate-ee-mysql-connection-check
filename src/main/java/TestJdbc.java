import dao.StudentDAO;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {


        String jdbcUrl  = "jdbc:mysql://localhost:6603/test?useSSL=false";
        String user = "root";
        String password = "pass";

        System.out.println("Connecting to the DB + " + jdbcUrl);

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        Student stud = new Student();

        stud.setFirst_name("Rick");
        stud.setLast_name("Martin");
        stud.setEmail("Ricky@gmail.com");







    }
}
