package ua.rd.relations.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        Department department = new Department("Logistics");
        Employee employee = new Employee(department, 500, "Rybin Ivan");


        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        em.persist(department);
        em.persist(employee);


        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
