package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "FISH")
//on doit mettre en place le inheriance join pour l'enumeration
@Inheritance(strategy = InheritanceType.JOINED)
public class Fish extends Animal implements Serializable {
    @Column(name = "LIVING_ENV")
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
