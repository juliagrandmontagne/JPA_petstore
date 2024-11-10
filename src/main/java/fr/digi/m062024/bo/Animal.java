package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    //creation des entité avec leurs propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "BIRTH")
    private LocalDateTime birth;
    @Column(name = "COULEUR")
    private String couleur;
    @ManyToOne
    @JoinColumn(name = "ID")
    private PetStore petstore;
    /**
     *constructeur vide pour permetrre a java de créer la bdd
     */

    public Animal() {
    }
    /**
     *to string
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", birth=").append(birth);
        sb.append(", couleur='").append(couleur).append('\'');
        sb.append('}');
        return sb.toString();
    }
    /**
     *getter et setter id
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     *getter et setter birth
     */
    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }
    /**
     *getter et setter Couleur
     */
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
