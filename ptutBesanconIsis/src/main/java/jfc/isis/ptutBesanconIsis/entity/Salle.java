package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

@Entity
public class Salle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "salle_id", insertable = false, updatable = false)
    private Integer salleId;
    @Basic
    @Column(name = "salle_nom")
    private String salleNom;

    public Integer getSalleId() {
        return salleId;
    }

    public void setSalleId(Integer salleId) {
        this.salleId = salleId;
    }

    public String getSalleNom() {
        return salleNom;
    }

    public void setSalleNom(String salleNom) {
        this.salleNom = salleNom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salle salle = (Salle) o;

        if (salleId != null ? !salleId.equals(salle.salleId) : salle.salleId != null) return false;
        if (salleNom != null ? !salleNom.equals(salle.salleNom) : salle.salleNom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = salleId != null ? salleId.hashCode() : 0;
        result = 31 * result + (salleNom != null ? salleNom.hashCode() : 0);
        return result;
    }
}
