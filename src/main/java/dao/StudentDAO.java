package dao;

import model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDAO {

    private EntityManager entityManager;

    public StudentDAO() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("testUnit");
        entityManager = factory.createEntityManager();
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student get(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void cleanUp() {
        entityManager.close();
    }

}
