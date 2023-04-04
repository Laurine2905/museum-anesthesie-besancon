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
public class Utilisateur {
    @Id
    @NonNull
    private String login;

    @Column(unique = true)
    @NonNull
    private String mdp;

    @Column(unique = true)
    @NonNull
    private boolean admin;
}
