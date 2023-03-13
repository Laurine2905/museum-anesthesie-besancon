package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
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
}
