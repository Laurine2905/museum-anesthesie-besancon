package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Salle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer salleId;
    @Column(unique=true)
    @NonNull
    private String salleNom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objet")
    private List<Objet> objet = new ArrayList<>();

}
