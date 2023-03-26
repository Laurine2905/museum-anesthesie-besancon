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
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NonNull
    private String nom;
    @Column(unique = true)
    private String description;
    @Column(unique = true)
    @NonNull
    private String urlPhoto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Objet> objet = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private List<Multimediacat> multimediacat = new ArrayList<>();
}
