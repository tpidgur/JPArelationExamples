package ua.rd.collectionmapping._2onetomanylist;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        PrintQueue queue = new PrintQueue();
        PrintJob job1 = new PrintJob(queue);
        PrintJob job2 = new PrintJob(queue);
        PrintJob job3 = new PrintJob(queue);
        queue.setJobs(Arrays.asList(job1, job2, job3));

        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();


        em.persist(queue);
        em.persist(job1);
        em.persist(job2);
        em.persist(job3);

        entityTransaction.commit();

        em.clear();
        em.close();
        emf.close();
    }
}
