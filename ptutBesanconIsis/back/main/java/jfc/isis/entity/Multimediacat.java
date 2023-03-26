package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Multimediacat {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer multicatId;
    @Column(unique=true)
    private String description;
    @Column(unique=true)
    private String urlPhotocat;
    @Column(unique=true)
    private String urlVideocat;
    @Column(unique=true)
    private String urlAudiocat;

}
