package jfc.isis.entity;


import lombok.*;
import jakarta.persistence.*;

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
}
