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
    @NonNull
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, pas de "setter"
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

    @ManyToOne(optional = false)
    @NonNull
    private Categorie categorie;

    @ManyToOne(optional = false)
    @NonNull
    private Salle salle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private List<Multimedia> multimedia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private List<ImageData> imageData = new ArrayList<>();

    public int compareTo(Objet o){
        int ret = 0;
        if (this.nom.compareTo(o.nom)<0) ret=-1;
        if (this.nom.compareTo(o.nom)>0) ret=1;
        return ret;
    }
}
