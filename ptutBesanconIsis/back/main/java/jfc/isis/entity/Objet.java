package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Objet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer objetId;
    @Column(unique=true)
    @NonNull
    private String objetNom;
    @Column(unique=true)
    private Integer annee;
    @Column(unique=true)
    private String createur;
    @Column(unique=true)
    private String pays;
    @Column(unique=true)
    private String objetDescription;
    @Column(unique=true)
    private Integer nbPossession;
    @Column(unique=true)
    @NonNull
    private String urlPhoto;

}
