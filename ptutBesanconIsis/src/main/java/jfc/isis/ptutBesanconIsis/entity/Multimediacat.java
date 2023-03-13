package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

@Entity
public class Multimediacat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "multicat_id")
    private Integer multicatId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "url_photocat")
    private String urlPhotocat;
    @Basic
    @Column(name = "url_videocat")
    private String urlVideocat;
    @Basic
    @Column(name = "url_audiocat")
    private String urlAudiocat;
    @OneToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id", nullable = false)
    private Categorie categorie_id;

    public Integer getMulticatId() {
        return multicatId;
    }

    public void setMulticatId(Integer multicatId) {
        this.multicatId = multicatId;
    }

    public String getUrlPhotocat() {
        return urlPhotocat;
    }

    public void setUrlPhotocat(String urlPhotocat) {
        this.urlPhotocat = urlPhotocat;
    }

    public String getUrlVideocat() {
        return urlVideocat;
    }

    public void setUrlVideocat(String urlVideocat) {
        this.urlVideocat = urlVideocat;
    }

    public String getUrlAudiocat() {
        return urlAudiocat;
    }

    public void setUrlAudiocat(String urlAudiocat) {
        this.urlAudiocat = urlAudiocat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Multimediacat that = (Multimediacat) o;

        if (multicatId != null ? !multicatId.equals(that.multicatId) : that.multicatId != null) return false;
        if (urlPhotocat != null ? !urlPhotocat.equals(that.urlPhotocat) : that.urlPhotocat != null) return false;
        if (urlVideocat != null ? !urlVideocat.equals(that.urlVideocat) : that.urlVideocat != null) return false;
        if (urlAudiocat != null ? !urlAudiocat.equals(that.urlAudiocat) : that.urlAudiocat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = multicatId != null ? multicatId.hashCode() : 0;
        result = 31 * result + (urlPhotocat != null ? urlPhotocat.hashCode() : 0);
        result = 31 * result + (urlVideocat != null ? urlVideocat.hashCode() : 0);
        result = 31 * result + (urlAudiocat != null ? urlAudiocat.hashCode() : 0);
        return result;
    }
}
