package dao;

import model.Student;
import javax.persistence.EntityManager;

public class StudentDAO {

    protected EntityManager entityManager;


    public StudentDAO() {

//        entityManager = PersistenceManager
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
