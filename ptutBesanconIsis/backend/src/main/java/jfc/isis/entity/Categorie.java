package jfc.isis.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Categorie implements Comparable<Categorie>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, pas de "setter"
    private Integer id;
    @Column(unique = true)
    @NonNull
    private String nom;
    @Column(unique = true)
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Objet> objet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Multimedia> multimedia = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<ImageData> imageData = new ArrayList<>();

    public int compareTo(Categorie c){
        int ret = 0;
        if (this.nom.compareTo(c.nom)<0) ret=-1;
        if (this.nom.compareTo(c.nom)>0) ret=1;
        return ret;
    }
}
