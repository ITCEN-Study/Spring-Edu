package jpalab.dao;

import jpalab.entity.StudentEntity;
import jakarta.persistence.*;
import java.util.List;

public class StudentDAO {
    // TODO : EntityManagerFactory 객체 생성시 emptest 명의 <persistence-unit> 태그를 사용한다.
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("emptest");

    public void close() {
        if (factory != null) factory.close();
    }

    // TODO : boolean insertStudent(StudentEntity entity)
    public boolean insertStudent(StudentEntity entity) {
        EntityManager em = factory.createEntityManager();
        boolean result = false;
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            System.out.println("insertStudent error: " + e.getMessage());
        } finally {
            em.close();
        }
        return result;
    }

    // TODO : List<StudentEntity> getAllStudent() -> 데이터가 없으면 비어있는 리스트 리턴
    public List<StudentEntity> getAllStudent() {
        EntityManager em = factory.createEntityManager();
        List<StudentEntity> list = null;
        try {
            TypedQuery<StudentEntity> q = em.createQuery("select s from StudentEntity s", StudentEntity.class);
            list = q.getResultList();
        } finally {
            em.close();
        }
        return list;
    }

    // TODO : StudentEntity getScore(String name) -> 존재하지 않는 학생명으로 호출하면 null 을 리턴
    public StudentEntity getScore(String name) {
        EntityManager em = factory.createEntityManager();
        StudentEntity student = null;
        try {
            student = em.find(StudentEntity.class, name);
        } finally {
            em.close();
        }
        return student;
    }

    // TODO : boolean updateStudent(StudentEntity entity)
    public boolean updateStudent(StudentEntity entity) {
        EntityManager em = factory.createEntityManager();
        boolean result = false;
        try {
            em.getTransaction().begin();
            StudentEntity student = em.find(StudentEntity.class, entity.getName());
            if (student != null) {
                student.setScore(entity.getScore());
                em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            System.out.println("updateStudent error: " + e.getMessage());
        } finally {
            em.close();
        }
        return result;
    }

    // TODO : boolean deleteStudent(String name)
    public boolean deleteStudent(String name) {
        EntityManager em = factory.createEntityManager();
        boolean result = false;
        try {
            em.getTransaction().begin();
            StudentEntity student = em.find(StudentEntity.class, name);
            if (student != null) {
                em.remove(student);
                em.getTransaction().commit();
                result = true;
            }
        } catch (Exception e) {
            System.out.println("deleteStudent error: " + e.getMessage());
        } finally {
            em.close();
        }
        return result;
    }
}
