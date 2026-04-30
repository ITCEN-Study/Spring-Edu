package jpaexam1.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jpaexam2.model.entity.Emp;

import java.util.List;

public class HelloJPA3_1 {
    public static void main(String[] args) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select t from Emp t", Emp.class);
        List<Emp> empList = q.getResultList();
        for (Emp elem : empList) {
            System.out.print(elem.getEname() + " : ");
            //  FetchType.LAZY 이고 또 아직 Dept 객체의 필드를 사용하는 것이 아니므로 Proxy 객체 생성되어 사용됨
            System.out.println(elem.getDeptno() != null ? elem.getDeptno().getClass().getName():"힝 ㅠㅠ~~");
        }
        System.out.println("데이터 갯수 : " + empList.size());
        em.close();
        factory.close();
    }
}
