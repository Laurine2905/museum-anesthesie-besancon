package jfc.isis.ptutBesanconIsis.dao;

import jfc.isis.ptutBesanconIsis.entity.Objet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.TreeSet;

public interface ObjetRepository extends JpaRepository<Objet, Integer> {

    Objet findByObjetNom(String objetNom);

    // SQL : formulée sur le modèle logique de données, il faut connaître la clé étrangère
    @Query(value="SELECT * FROM Objet WHERE categorie_id = :idDeLaCategorie", nativeQuery = true)
    TreeSet<Objet> getObjetsParCategorie(int idDeLaCategorie);

}