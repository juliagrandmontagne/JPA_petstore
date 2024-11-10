package fr.digi.m062024.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "CAT")
// on crée l'entité cat avec l'heritage de animal
public class Cat extends Animal implements Serializable {
    //propriété specifique aux chat
    @Column(name = "CHIP_ID")
    private String ChipID;

    /**
     * Constructeur sans argument pour jpa
     */
    public Cat() {
    }

    /**
     * getter et setter
     */
    public String getChipID() {
        return ChipID;
    }

    public void setChipID(String chipID) {
        ChipID = chipID;
    }
}
