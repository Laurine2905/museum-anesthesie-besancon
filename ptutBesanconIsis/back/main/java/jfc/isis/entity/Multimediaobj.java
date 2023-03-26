package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Multimediaobj {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer multiobjId;
    @Column(unique=true)
    private String description;
    @Column(unique=true)
    private String urlPhotoobj;
    @Column(unique=true)
    private String urlVideoobj;
    @Column(unique=true)
    private String urlAudioobj;

    @ManyToOne(optional = false)
    @NonNull
    private Objet objet;
}
