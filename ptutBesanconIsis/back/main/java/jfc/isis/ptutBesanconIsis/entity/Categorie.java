package jfc.isis.ptutBesanconIsis.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.*;
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Categorie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categorieId;
    @Column(unique=true)
    @NonNull
    private String categorieNom;
    @Column(unique=true)
    private String categorieDescription;
    @Column(unique=true)
    @NonNull
    private String urlPhoto;
}
