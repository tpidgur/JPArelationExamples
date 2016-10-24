package ua.rd.relations.embeddables;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JPArunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        Address address = new Address("Lomonosova 28, fl.40", "c.Kiev", "Ukraine", "03025");
        Employee e = new Employee("Ivanov Ivan", 100, address);
        Company company = new Company();
        company.setAddress(address);

        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();


        em.persist(e);
        em.persist(company);

        entityTransaction.commit();
        em.clear();
        em.close();
        emf.close();
    }
}
