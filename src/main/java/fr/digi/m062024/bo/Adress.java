package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ADRESS")
public class Adress implements Serializable {
    //creation des entité avec leurs propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NUMBER")
    private long number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIPCODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;

    /**
     * constructeur vide
     */
    public Adress() {
    }

    /**
     * methode to string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adress{");
        sb.append("id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", street='").append(street).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /*
     * Getter et setter id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /*
     *getter et setter number
     */
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
    /*
     *getter et setter street
     */
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    /*
     *getter et setter zipcode
     */
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    /*
     *getter et setter CITY
     */
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
