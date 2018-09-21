import dao.StudentDAO;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {


    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String password = "pass";

        System.out.println("Connecting to the DB + " + jdbcUrl);

        try {
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
// THIS ABOVE WORKS CORRECLTY  -  CONNECTION TO THE DB IS PROPER

              Student stud = new Student();
        stud.setFirst_name("Rick");
        stud.setLast_name("Sanchez");
        stud.setEmail("wubbalubba@gmail");

        EntityManager en = PersistenceManager.INSTANCE.getEntityManager();
//        StudentDAO dao  = new StudentDAO();
//        dao.save(stud);
        en.getTransaction().begin();
        en.persist(stud);
        en.getTransaction().commit();
        en.close();
        PersistenceManager.INSTANCE.close();
    }


}
