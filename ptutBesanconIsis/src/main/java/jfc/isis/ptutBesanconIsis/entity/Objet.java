package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

import java.util.TreeSet;

@Entity
public class Objet implements Comparable<Objet>{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "objet_id", insertable = false, updatable = false)
    private Integer objetId;
    @Basic
    @Column(name = "objet_nom")
    private String objetNom;
    @Basic
    @Column(name = "annee")
    private Integer annee;
    @Basic
    @Column(name = "createur")
    private String createur;
    @Basic
    @Column(name = "pays")
    private String pays;
    @Basic
    @Column(name = "objet_description")
    private String objetDescription;
    @Basic
    @Column(name = "nb_possession")
    private Integer nbPossession;
    @Basic
    @Column(name = "url_photo")
    private String urlPhoto;

    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id", nullable = false)
    private Categorie categorie_id;

    @OneToOne
    @JoinColumn(name = "salle_id", referencedColumnName = "salle_id", nullable = false)
    private Salle salle_id;

    public Integer getObjetId() {
        return objetId;
    }

    public void setObjetId(Integer objetId) {
        this.objetId = objetId;
    }

    public String getObjetNom() {
        return objetNom;
    }

    public void setObjetNom(String objetNom) {
        this.objetNom = objetNom;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getObjetDescription() {
        return objetDescription;
    }

    public void setObjetDescription(String objetDescription) {
        this.objetDescription = objetDescription;
    }

    public Integer getNbPossession() {
        return nbPossession;
    }

    public void setNbPossession(Integer nbPossession) {
        this.nbPossession = nbPossession;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objet objet = (Objet) o;

        if (objetId != null ? !objetId.equals(objet.objetId) : objet.objetId != null) return false;
        if (objetNom != null ? !objetNom.equals(objet.objetNom) : objet.objetNom != null) return false;
        if (annee != null ? !annee.equals(objet.annee) : objet.annee != null) return false;
        if (createur != null ? !createur.equals(objet.createur) : objet.createur != null) return false;
        if (pays != null ? !pays.equals(objet.pays) : objet.pays != null) return false;
        if (objetDescription != null ? !objetDescription.equals(objet.objetDescription) : objet.objetDescription != null)
            return false;
        if (nbPossession != null ? !nbPossession.equals(objet.nbPossession) : objet.nbPossession != null) return false;
        if (urlPhoto != null ? !urlPhoto.equals(objet.urlPhoto) : objet.urlPhoto != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = objetId != null ? objetId.hashCode() : 0;
        result = 31 * result + (objetNom != null ? objetNom.hashCode() : 0);
        result = 31 * result + (annee != null ? annee.hashCode() : 0);
        result = 31 * result + (createur != null ? createur.hashCode() : 0);
        result = 31 * result + (pays != null ? pays.hashCode() : 0);
        result = 31 * result + (objetDescription != null ? objetDescription.hashCode() : 0);
        result = 31 * result + (nbPossession != null ? nbPossession.hashCode() : 0);
        result = 31 * result + (urlPhoto != null ? urlPhoto.hashCode() : 0);
        return result;
    }

    public int compareTo(Objet o) {
        int ret = 0;
        if (this.objetNom.compareTo(o.objetNom)<0) ret=-1;
        if (this.objetNom.compareTo(o.objetNom)>0) ret=1;
        return ret;
    }

}
