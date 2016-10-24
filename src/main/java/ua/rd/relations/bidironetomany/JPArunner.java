package ua.rd.relations.bidironetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        Department department = new Department("Logistics");
        Employee employee = new Employee(department, 500, "Rybin Ivan");
        Employee employee2 = new Employee(department, 500, "Morkovka Artur");

        department.setEmployees(Arrays.asList(employee, employee2));


        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();

        em.persist(department);
        em.persist(employee);
        em.persist(employee2);


        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
