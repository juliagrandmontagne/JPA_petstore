package fr.digi.m062024.bo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PRODUCT")
//on doit mettre en place le inheriance join pour l'enumeration
@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable {
    //creation des entité avec leurs propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name ="CODE")
    private String code;
    @Column(name ="LABEL")
    private String label;
    @Column(name ="TYPE")
    @Enumerated(EnumType.STRING)
    private ProdType ProdType;
    @Column(name ="PRICE")
    private double price;

    /**
     * création des liaison en créant une table de jonction
     */
    @ManyToMany
    @JoinTable(
            name = "PRODUCTPETSTORE",
            joinColumns = @JoinColumn(name = "PRODUCTID"),
            inverseJoinColumns = @JoinColumn(name = "PETSTOREID")
    )
    private Set<PetStore> petStores;

    /**
     * Constrcteur sans argument pour permettre a java de créer les entité en bdd
     */
    public Product() {
    }
    /**
     * redefinission de la methode to string pour visualiser les elements
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", label='").append(label).append('\'');
        sb.append(", type='").append(ProdType).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
    /**
     * Getter et setter id
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     * Getter et setter code
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    /**
     * Getter et setter label
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    /**
     * Getter et setter type
     */
    public ProdType getProdType() {
        return ProdType;
    }

    public void setProdType(ProdType ProdType) {
        this.ProdType = ProdType;
    }
    /**
     * Getter et setter price
     */
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
