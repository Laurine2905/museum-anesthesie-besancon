package jfc.isis.entity;


import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categorieId;
    @Column(unique=true)
    @NonNull
    private String categorieNom;
    @Column(unique=true)
    private String categorieDescription;
    @Column(unique=true)
    @NonNull
    private String urlPhoto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private List<Objet> objet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multimedia")
    private List<Multimediacat> multimediacat = new ArrayList<>();
}
