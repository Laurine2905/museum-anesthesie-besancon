package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Objet implements Comparable<Objet>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NonNull
    private String nom;
    @Column(unique = true)
    private Integer annee;
    @Column(unique = true)
    private String createur;
    @Column(unique = true)
    private String pays;
    @Column(unique = true)
    private String description;
    @Column(unique = true)
    private Integer nbPossession;
    @Column(unique = true)
    @NonNull
    private byte[] urlPhoto;

    @ManyToOne(optional = false)
    @NonNull
    private Categorie categorie;

    @ManyToOne(optional = false)
    @NonNull
    private Salle salle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private List<Multimediaobj> multimediaobjs = new ArrayList<>();

    public int compareTo(Objet o){
        int ret = 0;
        if (this.nom.compareTo(o.nom)<0) ret=-1;
        if (this.nom.compareTo(o.nom)>0) ret=1;
        return ret;
    }
}
