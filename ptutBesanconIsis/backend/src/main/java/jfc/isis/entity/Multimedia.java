package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    @Setter(AccessLevel.NONE) // la clé est auto-générée par la BD, pas de "setter"
    private Integer id;
    @Column(unique = true)
    private String description;

    @Column(unique = true)
    private String urlVideocat;
    @Column(unique = true)
    private String urlAudiocat;

    @ManyToOne(optional = true)
    private Categorie categorie;

    @ManyToOne(optional = true)
    private Objet objet;
}
