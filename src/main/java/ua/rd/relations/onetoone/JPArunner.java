package ua.rd.relations.onetoone;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();


        ParkingSpace space = new ParkingSpace();
        Employee e = new Employee(space,15,"Iren Adler");


        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        em.persist(space);
        em.persist(e);


        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
