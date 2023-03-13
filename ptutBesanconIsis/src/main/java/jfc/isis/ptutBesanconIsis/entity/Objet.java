package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Objet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "objet_id", insertable = false, updatable = false)
    private Integer objetId;
    @Basic
    @Column(name = "objet_nom")
    private String objetNom;
    @Basic
    @Column(name = "annee")
    private Integer annee;
    @Basic
    @Column(name = "createur")
    private String createur;
    @Basic
    @Column(name = "pays")
    private String pays;
    @Basic
    @Column(name = "objet_description")
    private String objetDescription;
    @Basic
    @Column(name = "nb_possession")
    private Integer nbPossession;
    @Basic
    @Column(name = "url_photo")
    private String urlPhoto;

    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id", nullable = false)
    private Categorie categorie_id;

    @OneToOne
    @JoinColumn(name = "salle_id", referencedColumnName = "salle_id", nullable = false)
    private Salle salle_id;

}
