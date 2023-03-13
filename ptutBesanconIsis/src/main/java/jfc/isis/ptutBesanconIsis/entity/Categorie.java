package jfc.isis.ptutBesanconIsis.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
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
}
