package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore implements Serializable {
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

    @OneToOne
    @JoinColumn(name = "ID")
    private Adress adress;


    @OneToMany(mappedBy = "petstore")
    private Set<Animal> animals;

    @ManyToMany(mappedBy = "petStores") // Le mappedBy fait référence à l'attribut 'petStores' dans Product
    private Set<Product> products;

    /**
     * methode to string
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
