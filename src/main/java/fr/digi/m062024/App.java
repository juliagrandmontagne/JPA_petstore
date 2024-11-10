package fr.digi.m062024;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bdd2");
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.close();
        managerFactory.close();
    }
}
