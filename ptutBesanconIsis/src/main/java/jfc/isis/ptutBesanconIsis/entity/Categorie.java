package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;
@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categorie_id", insertable = false, updatable = false)
    private Integer categorieId;
    @Basic
    @Column(name = "categorie_nom")
    private String categorieNom;
    @Basic
    @Column(name = "categorie_description")
    private String categorieDescription;
    @Basic
    @Column(name = "url_photo")
    private String urlPhoto;

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public String getCategorieNom() {
        return categorieNom;
    }

    public void setCategorieNom(String categorieNom) {
        this.categorieNom = categorieNom;
    }

    public String getCategorieDescription() {
        return categorieDescription;
    }

    public void setCategorieDescription(String categorieDescription) {
        this.categorieDescription = categorieDescription;
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

        Categorie categorie = (Categorie) o;

        if (categorieId != null ? !categorieId.equals(categorie.categorieId) : categorie.categorieId != null)
            return false;
        if (categorieNom != null ? !categorieNom.equals(categorie.categorieNom) : categorie.categorieNom != null)
            return false;
        if (categorieDescription != null ? !categorieDescription.equals(categorie.categorieDescription) : categorie.categorieDescription != null)
            return false;
        if (urlPhoto != null ? !urlPhoto.equals(categorie.urlPhoto) : categorie.urlPhoto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categorieId != null ? categorieId.hashCode() : 0;
        result = 31 * result + (categorieNom != null ? categorieNom.hashCode() : 0);
        result = 31 * result + (categorieDescription != null ? categorieDescription.hashCode() : 0);
        result = 31 * result + (urlPhoto != null ? urlPhoto.hashCode() : 0);
        return result;
    }
}
