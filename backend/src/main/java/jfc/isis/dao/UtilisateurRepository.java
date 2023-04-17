package jfc.isis.dao;

import jfc.isis.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Utilisateur findByLogin(String login);

}
