package dao;

import model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentDAO {


    private EntityManagerFactory emFactory;
    private EntityManager entityManager;


    public StudentDAO() {
        emFactory = Persistence.createEntityManagerFactory("testUnit");
        entityManager = emFactory.createEntityManager();
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student get(Long id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    public void cleanUp() {
        entityManager.close();
        emFactory.close();
    }


}
