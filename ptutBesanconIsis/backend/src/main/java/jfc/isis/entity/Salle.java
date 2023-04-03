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
public class Salle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, pas de "setter"
    private Integer id;
    @Column(unique = true)
    @NonNull
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salle")
    private List<Objet> objet = new ArrayList<>();

}
