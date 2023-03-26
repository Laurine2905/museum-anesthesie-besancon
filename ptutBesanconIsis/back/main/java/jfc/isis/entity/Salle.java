package jfc.isis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Salle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer salleId;
    @Column(unique=true)
    @NonNull
    private String salleNom;
}
