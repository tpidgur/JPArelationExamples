package ua.rd.relations.manytomany;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        Employee e1 = new Employee(500, "Bob Marly");
        Employee e2 = new Employee(500, "Renata Jaresko");
        Employee e3 = new Employee(500, "Tom Akhmetov");

        Project pr1 = new Project("System Integration");
        Project pr2 = new Project("Big data");

        pr1.setEmployees(Arrays.asList(e1,e3));
        pr2.setEmployees(Arrays.asList(e2,e3));


        e1.setProjects(Arrays.asList(pr1));
        e2.setProjects(Arrays.asList(pr2));
        e3.setProjects(Arrays.asList(pr1,pr2));




        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();


        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(pr1);
        em.persist(pr2);

        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
