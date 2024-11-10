package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
//on crée l'entité fish avec l'heritage de animal
@Table(name = "FISH")
//on doit mettre en place le inheriance join pour l'enumeration
@Inheritance(strategy = InheritanceType.JOINED)
public class Fish extends Animal implements Serializable {
    @Column(name = "LIVING_ENV")
    // ici la propriété est une enumeration qui est une class a part car elle s'inscrit dans la strategie 1 table par classe / Joined
    @Enumerated(EnumType.STRING)
    private LivingEnvironment livingEnvironement;

    /**
     * constructeur sans argument
     */
    public Fish() {
    }

    /**
     * GETTER AND SETTER
     */
    public LivingEnvironment getLivingEnvironement() {
        return livingEnvironement;
    }

    public void setLivingEnvironement(LivingEnvironment livingEnvironement) {
        this.livingEnvironement = livingEnvironement;
    }
}
