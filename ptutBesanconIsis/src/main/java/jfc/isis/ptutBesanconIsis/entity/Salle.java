package jfc.isis.ptutBesanconIsis.entity;

import jakarta.persistence.*;

import lombok.*;
@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Salle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "salle_id", insertable = false, updatable = false)
    private Integer salleId;
    @Basic
    @Column(name = "salle_nom")
    private String salleNom;
}
