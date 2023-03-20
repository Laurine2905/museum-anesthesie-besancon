package jfc.isis.ptutBesanconIsis.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter @NoArgsConstructor
@RequiredArgsConstructor @ToString
@Entity // Une entité JPA
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
