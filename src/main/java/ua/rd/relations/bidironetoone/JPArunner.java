package ua.rd.relations.bidironetoone;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        Employee e = new Employee();
        ParkingSpace space = new ParkingSpace(5, "Kiev", e);
        e.setParkingSpace(space);
        e.setSalary(10);
        e.setName("Ivanov Ivan");


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
