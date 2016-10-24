package ua.rd.collectionmapping._1elementcollection;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        VacationEntry v1 = new VacationEntry(Calendar.getInstance(), 15);
        VacationEntry v2 = new VacationEntry(new GregorianCalendar(2013, 0, 31), 10);

        Employee e1 = new Employee("Ivanov Ivan", 500, new HashSet<String>
                (Arrays.asList("Ivan25", "Iva", "IvIvanov")));
        Employee e2 = new Employee("Iren Adler", 500, new HashSet<String>
                (Arrays.asList("Iren", "Irr", "Addl")));

        e1.setVacationBookings(Arrays.asList(v1, v2));
        e2.setVacationBookings(Arrays.asList(v1));

        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();


        em.persist(e1);
        em.persist(e2);


        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
