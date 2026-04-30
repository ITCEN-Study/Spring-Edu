package jpaexam1.app;

import jpaexam1.entity.EntityTest1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class EntityTestApp4 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entitytest");
        EntityManager em = factory.createEntityManager();
        EntityTest1 et;
        em.getTransaction().begin();
        System.out.println("엔티티 삭제");
    	EntityTest1 finalData = em.find(EntityTest1.class, 0); // 두 번째  아규먼트 설정
    	em.remove(finalData);

        TypedQuery<EntityTest1> q = em.createQuery("select t from EntityTest1 t", EntityTest1.class);
    	List<EntityTest1> list = q.getResultList();
    	list.stream().forEach(System.out::println);
    	System.out.println("엔터키.....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        //em.getTransaction().commit();
        em.close();       
        factory.close();
        scan.close();
	}
}
