package fr.digi.m062024;

import fr.digi.m062024.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("bdd2");
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
        entityManager.getTransaction().begin();
        PetStore petStore1 = new PetStore();
        petStore1.setName("il boude");
        petStore1.setManagername("Camille Honête");

        PetStore petStore2 = new PetStore();
        petStore2.setName("Optichien");
        petStore2.setManagername("Rémi Fasol");

        PetStore petStore3 = new PetStore();
        petStore3.setName("La poule de cristal");
        petStore3.setManagername("Rémi Fasol");

        entityManager.persist(petStore1);
        entityManager.persist(petStore2);
        entityManager.persist(petStore3);

        Product product1 = new Product();
        product1.setCode("P001");
        product1.setLabel("CROQUETTE");
        product1.setProdType(ProdType.FOOD);
        product1.setPrice(10.99);

        Product product2 = new Product();
        product2.setCode("P002");
        product2.setLabel("LAISSE A POISSON");
        product2.setProdType(ProdType.ACCESSORY);
        product2.setPrice(30.50);

        Product product3 = new Product();
        product3.setCode("P003");
        product3.setLabel("LAISSE");
        product3.setProdType(ProdType.ACCESSORY);
        product3.setPrice(15.75);

        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);

        Cat cat1 = new Cat();
        cat1.setBirth(LocalDateTime.now());
        cat1.setCouleur("BLACK");
        cat1.setChipID("JESUISLA23");

        Fish fish1 = new Fish();
        fish1.setBirth(LocalDateTime.now());
        fish1.setCouleur("RED");
        fish1.setLivingEnvironement(LivingEnvironment.FRESH_WATER);

        Fish fish2 = new Fish();
        fish2.setBirth(LocalDateTime.now());
        fish2.setCouleur("BLUE");
        fish2.setLivingEnvironement(LivingEnvironment.SEA_WATER);

        entityManager.persist(cat1);
        entityManager.persist(fish1);
        entityManager.persist(fish2);
        entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

            entityManager.getTransaction().rollback();
        } finally {

            entityManager.close();
            managerFactory.close();
        }
    }
}
