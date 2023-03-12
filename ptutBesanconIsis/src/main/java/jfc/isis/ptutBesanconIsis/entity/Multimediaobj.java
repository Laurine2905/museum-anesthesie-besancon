package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

@Entity
public class Multimediaobj {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "multiobj_id")
    private Integer multiobjId;

    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "url_photoobj")
    private String urlPhotoobj;
    @Basic
    @Column(name = "url_videoobj")
    private String urlVideoobj;
    @Basic
    @Column(name = "url_audioobj")
    private String urlAudioobj;
    @OneToOne
    @JoinColumn(name = "objet_id", referencedColumnName = "objet_id", nullable = false)
    private Objet objet_id;

    public Integer getMultiobjId() {
        return multiobjId;
    }

    public void setMultiobjId(Integer multiobjId) {
        this.multiobjId = multiobjId;
    }

    public String getUrlPhotoobj() {
        return urlPhotoobj;
    }

    public void setUrlPhotoobj(String urlPhotoobj) {
        this.urlPhotoobj = urlPhotoobj;
    }

    public String getUrlVideoobj() {
        return urlVideoobj;
    }

    public void setUrlVideoobj(String urlVideoobj) {
        this.urlVideoobj = urlVideoobj;
    }

    public String getUrlAudioobj() {
        return urlAudioobj;
    }

    public void setUrlAudioobj(String urlAudioobj) {
        this.urlAudioobj = urlAudioobj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Multimediaobj that = (Multimediaobj) o;

        if (multiobjId != null ? !multiobjId.equals(that.multiobjId) : that.multiobjId != null) return false;
        if (urlPhotoobj != null ? !urlPhotoobj.equals(that.urlPhotoobj) : that.urlPhotoobj != null) return false;
        if (urlVideoobj != null ? !urlVideoobj.equals(that.urlVideoobj) : that.urlVideoobj != null) return false;
        if (urlAudioobj != null ? !urlAudioobj.equals(that.urlAudioobj) : that.urlAudioobj != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = multiobjId != null ? multiobjId.hashCode() : 0;
        result = 31 * result + (urlPhotoobj != null ? urlPhotoobj.hashCode() : 0);
        result = 31 * result + (urlVideoobj != null ? urlVideoobj.hashCode() : 0);
        result = 31 * result + (urlAudioobj != null ? urlAudioobj.hashCode() : 0);
        return result;
    }
}
