package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
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
}
