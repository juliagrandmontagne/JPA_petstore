package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore implements Serializable {
    // creation des entité avec leurs propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NAME_MANAGER")
    private String managername;


    /**
     * constructeur vide
     */
    public PetStore() {
    }
    /**
     * création des liaison
     */
    //on crée une liaison 1to one pour respecter la cardinalité petstore qui possede une seule adresse
    @OneToOne
    @JoinColumn(name = "ID")
    private Adress adress;

    //on crée une liaison one to many pour respecter la cardinalité petstore qui possede plusieurs animaux (normalment)
    @OneToMany(mappedBy = "petstore")
    private Set<Animal> animals;

    //on crée une une liaison many to many les produit sont vendu dans plusieur petstore inversement
    @ManyToMany(mappedBy = "petStores")
    private Set<Product> products;

    /**
     *  methode to string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetStore{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", managername='").append(managername).append('\'');
        sb.append('}');
        return sb.toString();
    }


    /**
     * getter et setter du nom
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }
}
